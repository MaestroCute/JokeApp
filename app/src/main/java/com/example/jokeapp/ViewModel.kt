package com.example.jokeapp

import androidx.annotation.DrawableRes

class ViewModel(private val model: Model) {

    private var dataCallback: DataCallback? = null

    private val jokeCallback = object: JokeCallback {
        override fun provide(jokeUiModel: JokeUiModel) {
            dataCallback?.let {
                jokeUiModel.map(it)
            }
        }

    }

    fun init(callback: DataCallback) {
        dataCallback = callback
        model.init(jokeCallback)
    }

    fun changeJokeStatus() {
        model.changeJokeStatus(jokeCallback)
    }

    fun getJoke() {
        model.getJoke()
    }

    fun clear() {
        dataCallback = null
        model.clear()
    }

    fun chooseFavorites(favorites: Boolean) {
        model.chooseDataSource(favorites)
    }
}


interface DataCallback {
    fun provideText(text: String)

    fun provideIconRes(@DrawableRes id:Int)
}