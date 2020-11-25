package com.iskhakoff.domain

import com.iskhakoff.data.remote.models.Hero
import kotlinx.coroutines.Deferred

interface HeroesRepository {
    suspend fun fetchHeroes(): Deferred<List<Hero>>
}