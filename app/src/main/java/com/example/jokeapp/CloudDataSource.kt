package com.example.jokeapp

interface CloudDataSource {
    fun getJoke(callback: JokeCloudCallback)
}

interface JokeCloudCallback {
    fun provide(joke: Joke)
    fun fail(errorType: ErrorType)
}

enum class ErrorType {
    NO_CONNETCTION,
    SERVICE_UNAVAILABLE
}