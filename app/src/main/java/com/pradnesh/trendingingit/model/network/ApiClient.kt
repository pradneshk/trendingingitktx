package com.pradnesh.trendingingit.model.network

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private const val BASE_URL = "https://api.github.com/"

    val searchService: ApiService = Retrofit.Builder().run{
        val gson = GsonBuilder()
            .enableComplexMapKeySerialization()
            .setPrettyPrinting()
            .create()
        baseUrl(BASE_URL)
        addConverterFactory(GsonConverterFactory.create(gson))
        client(createRequestorInterceptorClient())
        build()
    }.create(ApiService::class.java)

    private fun createRequestorInterceptorClient(): OkHttpClient{
        val interceptor = Interceptor{chain ->
            val orignal = chain.request()
            val requestBuilder = orignal.newBuilder()
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
    }
}