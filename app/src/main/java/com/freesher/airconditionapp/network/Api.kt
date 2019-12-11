package com.freesher.airconditionapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL =
    "http://api.gios.gov.pl/pjp-api/rest/"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

object AirConditionApi {
    val retrofitService: AirConditionService by lazy {
        retrofit.create(AirConditionService::class.java)
    }
}

