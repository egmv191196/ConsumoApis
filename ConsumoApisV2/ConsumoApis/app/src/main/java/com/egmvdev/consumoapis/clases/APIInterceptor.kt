package com.egmvdev.consumoapis.clases

import okhttp3.Interceptor
import okhttp3.Response

class APIInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain
                .request()
                .newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Authorization","Bearer 1234567890")
                .build()
        )

}