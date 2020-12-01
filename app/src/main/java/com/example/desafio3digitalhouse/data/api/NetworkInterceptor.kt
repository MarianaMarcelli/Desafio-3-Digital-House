package com.example.desafio3digitalhouse.data.api

import com.example.desafio3digitalhouse.data.extensions.md5
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val original = chain.request()
        val originalHttpUrl = original.url()

        val ts = System.currentTimeMillis().toString()
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("apikey", API_KEY)
            .addQueryParameter("ts", ts)
            .addQueryParameter("hash", "$ts$PRIVATE_KEY$API_KEY".md5())
            .build()

        return chain.proceed(original.newBuilder().url(url).build())
    }
}
