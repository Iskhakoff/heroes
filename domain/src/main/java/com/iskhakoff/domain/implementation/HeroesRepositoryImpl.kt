package com.iskhakoff.domain.implementation

import com.iskhakoff.data.remote.HeroesProvider
import com.iskhakoff.domain.HeroesRepository
import com.iskhakoff.data.remote.models.Hero
import kotlinx.coroutines.*

class HeroesRepositoryImpl(val heroesProvider: HeroesProvider): HeroesRepository {
    override suspend fun fetchHeroes(): Deferred<List<Hero>> {
        return heroesProvider.fetchHeroes()
    }
}