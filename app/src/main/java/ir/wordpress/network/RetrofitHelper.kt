package ir.wordpress.network

import retrofit.GsonConverterFactory
import retrofit.Retrofit

object RetrofitHelper {

    val baseUrl="http://localhost/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    }