package com.iskhakoff.data.remote

import com.iskhakoff.data.remote.models.Hero
import kotlinx.coroutines.Deferred

interface HeroesProvider {
    suspend fun fetchHeroes(): Deferred<List<Hero>>
}