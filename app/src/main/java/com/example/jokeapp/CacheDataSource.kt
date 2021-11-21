package com.example.jokeapp

interface CacheDataSource {

    fun getJoke(jokeCachedCallback: JokeCachedCallback)

    fun addOrRemove(id: Int, joke: Joke): JokeUiModel
}

interface JokeCachedCallback {
    fun provide(joke: Joke)

    fun fail()
}