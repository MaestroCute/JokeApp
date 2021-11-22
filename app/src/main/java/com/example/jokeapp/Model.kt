package com.example.jokeapp

interface Model{

    suspend fun getJoke() : JokeUiModel

    suspend fun changeJokeStatus() : JokeUiModel?

    fun chooseDataSource(cached: Boolean)
}