package com.example.jokeapp

interface JokeCloudCallback {
    fun provide(joke: JokeServerModel)
    fun fail(errorType: ErrorType)
}

enum class ErrorType {
    NO_CONNETCTION,
    SERVICE_UNAVAILABLE
}