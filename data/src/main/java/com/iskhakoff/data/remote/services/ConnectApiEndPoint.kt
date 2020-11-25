package com.iskhakoff.data.remote.services

import com.iskhakoff.data.remote.models.Hero
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ConnectApiEndPoint{
    @GET("./heroesStats")
    fun getHeroes(): Deferred<List<Hero>>
}