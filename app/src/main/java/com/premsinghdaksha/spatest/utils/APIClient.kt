package com.premsinghdaksha.spatest.utils

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    private var retrofit: Retrofit? = null
    val client: Retrofit?
        get() {
            val client = OkHttpClient.Builder()
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(loggingInterceptor)

            return Retrofit.Builder().baseUrl("https://api.giphy.com/v1/gifs/").addConverterFactory(
                GsonConverterFactory.create()
            ).client(client.build()).build();
        }
}
