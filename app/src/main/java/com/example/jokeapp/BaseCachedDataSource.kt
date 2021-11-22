package com.example.jokeapp

import io.realm.Realm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BaseCachedDataSource(private val realmProvider: RealmProvider) : CacheDataSource {

    override suspend fun getJoke(): Result<Joke, Unit> {
        realmProvider.provide().use {
            val jokes = it.where(JokeRealm::class.java).findAll()
            if(jokes.isEmpty())
                return Result.Error(Unit)
            else
                jokes.random().let { joke ->
                    return Result.Success(
                        Joke(
                            joke.id,
                            joke.type,
                            joke.text,
                            joke.punchline
                        )
                    )
                }
        }
    }

    override suspend fun addOrRemove(id: Int, joke: Joke): JokeUiModel =
        withContext(Dispatchers.IO) {
            Realm.getDefaultInstance().use {
            val jokeRealm =
                it.where(JokeRealm::class.java).equalTo("id", id).findFirst()
            return@withContext if(jokeRealm == null) {
                it.executeTransactionAsync { transaction ->
                    val newJoke = joke.toJokeRealm()
                    transaction.insert(newJoke)
                }
                joke.toFavoriteJoke()
            } else {
                it.executeTransactionAsync {
                    jokeRealm.deleteFromRealm()
                }
                joke.toBaseJoke()
            }
        }
    }


}