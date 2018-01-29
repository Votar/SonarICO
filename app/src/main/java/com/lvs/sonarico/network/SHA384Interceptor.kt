package com.lvs.sonarico.network

import android.util.Base64
import com.lvs.sonarico.encodeBase64
import com.lvs.sonarico.requestToString
import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec


/**
 * Created by lipchenko on 29.01.18.
 */
class SHA384Interceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        if (originalRequest.body() != null) {
            val sig = encodeSHA384(originalRequest.body()!!.requestToString(), Api.PRIVATE_KEY)
            val encryptedRequest = originalRequest.newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("X-ICObench-Key", Api.PUBLIC_KEY)
                    .addHeader("X-ICObench-Sig", sig)
                    .build()


            return chain.proceed(encryptedRequest)
        } else
            return chain.proceed(originalRequest)
    }

    fun encodeSHA384(data: String, key: String): String {
        var returnString = ""
        try {
            val keySpec = SecretKeySpec(key.toByteArray(), "HmacSHA384")
            val mac = Mac.getInstance("HmacSHA384")
            mac.init(keySpec)
            val dataByteArray = mac.doFinal(data.toByteArray())
            returnString = Base64.encodeToString(dataByteArray, Base64.NO_WRAP)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return returnString
    }


}