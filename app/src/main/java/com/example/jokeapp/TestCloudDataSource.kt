package com.example.jokeapp

class TestCloudDataSource : CloudDataSource {
    private var count = 0
    override fun getJoke(callback: JokeCloudCallback) {
        val joke = (JokeServerModel(count, "testType", "testString$count", "testPunchline$count"))
        callback.provide(joke)
        count++
    }
}