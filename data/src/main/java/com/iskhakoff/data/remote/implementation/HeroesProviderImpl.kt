package com.iskhakoff.data.remote.implementation

import com.iskhakoff.data.remote.ConnectApi
import com.iskhakoff.data.remote.HeroesProvider
import com.iskhakoff.data.remote.models.Hero
import kotlinx.coroutines.Deferred

class HeroesProviderImpl: HeroesProvider {
    override suspend fun fetchHeroes(): Deferred<List<Hero>> {
        return ConnectApi.getHeroes()
    }
}