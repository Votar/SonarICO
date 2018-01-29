package com.lvs.sonarico.network

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Path


/**
 * Created by lipchenko on 25.01.18.
 */
interface CommonApiService {
    @POST("icos/{type}")
    fun icoList(@Path("type") type: String): Call<String>

}