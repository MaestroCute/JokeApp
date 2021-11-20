package com.example.jokeapp

import retrofit2.Call
import retrofit2.http.GET

interface JokeService {

    @GET("https://joke.deno.dev")
    fun getJoke() : Call<JokeServerModel>
}

//interface ServiceCallback {
//    fun returnSuccess(data: JokeServerModel)
//
//    fun returnError(type: ErrorType)
//}
//
//enum class ErrorType {
//    NO_CONNECTION,
//    OTHER
//}