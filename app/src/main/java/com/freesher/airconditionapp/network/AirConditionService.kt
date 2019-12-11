package com.freesher.airconditionapp.network

import com.freesher.airconditionapp.model.Measure
import com.freesher.airconditionapp.model.Sensor
import com.freesher.airconditionapp.model.Station
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AirConditionService {
    @GET("station/findAll")
    fun getAllStations(): Call<List<Station>>
    @GET("sensors/{stationId}")
    fun getSensors(@Path("stationId") stationId:Int):Call<List<Sensor>>
    @GET("getData/{sensorId}")
    fun getMeasures(@Path("sensorId") sensorId:Int):Call<List<Measure>>
}