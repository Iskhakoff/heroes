package com.iskhakoff.data.remote

import com.iskhakoff.data.remote.models.Hero
import com.iskhakoff.data.remote.services.ConnectApiEndPoint
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Deferred
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

public class ConnectApi {

    companion object {
        private val BASE_URL = "https://api.opendota.com/api/"

        private fun getOkHttpInstance(): OkHttpClient{
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()
        }

        private fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpInstance())
                .addConverterFactory(Json.nonstrict.asConverterFactory(contentType = "application/json".toMediaType()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        }

        fun getHeroes() = getRetrofitInstance().create(ConnectApiEndPoint::class.java).getHeroes()
    }



}