package com.example.jokeapp

import io.realm.Realm

interface RealmProvider  {
    fun provide(): Realm
}

class BaseRealmProvider : RealmProvider{
    override fun provide(): Realm = Realm.getDefaultInstance()
}