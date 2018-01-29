package com.lvs.sonarico.network

import retrofit2.Retrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory

object Api {

    const val BASE_URL = "https://icobench.com/api/v1/"
    const val PRIVATE_KEY = "32295c87-3025-4b15-8423-e205f82a23ec"
    const val PUBLIC_KEY = "dd16067a-2474-48de-b0f7-76b3063cbe34"


    val common: CommonApiService

    init {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()

        client.addInterceptor(SHA384Interceptor())
        client.addInterceptor(loggingInterceptor)

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()

        common = retrofit.create<CommonApiService>(CommonApiService::class.java)
    }
}