package com.example.jokeapp

interface Model{

    fun getJoke()

    fun init(callback: JokeCallback)

    fun changeJokeStatus(jokeCallback: JokeCallback)

    fun clear()

    fun chooseDataSource(cached: Boolean)
}

interface JokeCallback {
    fun provide(jokeUiModel: JokeUiModel)
}