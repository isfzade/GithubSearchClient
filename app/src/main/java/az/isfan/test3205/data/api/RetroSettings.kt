package az.isfan.test3205.data.api

import az.isfan.test3205.data.api.dao.ApiDao
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetroSettings {
    private const val BASE_URL = "https://api.github.com"

    private val client = OkHttpClient.Builder()
        .addInterceptor(HeaderInterceptor())
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiDao by lazy {
        retrofit.create(ApiDao::class.java)
    }
}