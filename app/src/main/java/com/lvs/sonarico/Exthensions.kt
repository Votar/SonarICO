package com.lvs.sonarico

import android.util.Base64
import okhttp3.RequestBody
import okio.Buffer
import java.io.IOException
import java.nio.charset.Charset

/**
 * Created by lipchenko on 29.01.18.
 */

fun RequestBody.requestToString(): String {
    return try {
        val buffer = Buffer()
        this.writeTo(buffer)
        buffer.readUtf8()
    } catch (e: IOException) {
        "did not work"
    }
}

fun String.encodeBase64() : String {
    val data = this.toByteArray(Charset.forName("UTF-8"))
    return Base64.encodeToString(data, Base64.NO_WRAP)
}

fun String.decodeBase64() : String{
    val data = Base64.decode(this, Base64.NO_WRAP)
    return  String(data, Charset.forName("UTF-8"))
}
