package com.example.jokeapp

import com.google.gson.annotations.SerializedName

data class JokeServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("type")
    private val type: String,
    @SerializedName("setup")
    private val text: String,
    @SerializedName("punchline")
    private val punchline: String
) {
    fun toJoke() = Joke(id, type, text, punchline)

//    fun toBaseJoke() = BaseJokeUiModel(text, punchline)
//
//    fun toFavoriteJoke() = FavoriteJokeUiModel(text, punchline)
//
//    fun toJokeRealm(): JokeRealm {
//        return JokeRealm().also {
//            it.id = id
//            it.type = type
//            it.text = text
//            it.punchline = punchline
//        }
//    }
//
//    fun change(cacheDataSource: CacheDataSource) = cacheDataSource.addOrRemove(id, this)
}
