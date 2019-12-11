package com.freesher.airconditionapp.model

import com.google.gson.annotations.SerializedName

data class Station(
    val id:Int,
    @SerializedName("stationName")
    val name:String
)