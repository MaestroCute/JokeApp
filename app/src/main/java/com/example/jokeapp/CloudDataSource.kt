package com.example.jokeapp

interface CloudDataSource {
    suspend fun getJoke() : Result<JokeServerModel, ErrorType>
}

enum class ErrorType {
    NO_CONNETCTION,
    SERVICE_UNAVAILABLE
}