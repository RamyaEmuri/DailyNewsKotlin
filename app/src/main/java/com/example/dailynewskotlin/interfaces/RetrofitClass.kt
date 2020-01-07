package com.example.dailynewskotlin.interfaces

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClass private constructor() {
    companion object {
        private var apiMethodInterface: ApiMethodInterface? = null
        private var retrofit: Retrofit? = null
        fun getClient(): ApiMethodInterface? {
            retrofit = retrofit ?: Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            apiMethodInterface =
                apiMethodInterface ?: retrofit?.create(ApiMethodInterface::class.java)
            return apiMethodInterface
        }
    }
}
