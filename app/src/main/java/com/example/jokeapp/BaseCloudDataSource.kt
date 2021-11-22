package com.example.jokeapp

import android.util.Log
import java.net.UnknownHostException

class BaseCloudDataSource(private val service: JokeService) : CloudDataSource {
    override suspend fun getJoke(): Result<JokeServerModel, ErrorType> {
        return try {
            val result : JokeServerModel = service.getJoke().execute().body()!!
            Log.d("threadLogTag","currentThread ${Thread.currentThread().name}")
            Result.Success(result)
        } catch (e: Exception) {
            val errorType = if (e is UnknownHostException)
                ErrorType.NO_CONNETCTION
            else
                ErrorType.SERVICE_UNAVAILABLE
            Result.Error(errorType)
        }
    }
}