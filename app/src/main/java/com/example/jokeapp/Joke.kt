package com.example.jokeapp

import androidx.annotation.DrawableRes

class BaseJoke(text: String, punchline: String) : Joke(text, punchline) {
    override fun getIconResId() = R.drawable.ic_favorite_border
}

class FavoriteJoke(text: String, punchline: String) : Joke(text, punchline) {
    override fun getIconResId() = R.drawable.ic_favorite
}

class FailedJoke(text: String) : Joke(text, "") {
    override fun getIconResId() = 0
}

abstract class Joke(private val text: String, private val punchline: String) {

    protected fun getJokeUI() = "$text\n$punchline"

    @DrawableRes
    protected abstract fun getIconResId(): Int

    fun map(callback: DataCallback) = callback.run {
        provideText(getJokeUI())
        provideIconRes(getIconResId())
    }
}