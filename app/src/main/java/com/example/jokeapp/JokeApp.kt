package com.example.jokeapp

import android.app.Application
import com.google.gson.Gson

class JokeApp : Application() {

    lateinit var viewModel: ViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = ViewModel(BaseModel(BaseJokeService(Gson()), BaseResourceManager(this)))
    }
}