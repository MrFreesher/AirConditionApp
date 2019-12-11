package com.freesher.airconditionapp.model

import com.google.gson.annotations.SerializedName

data class Sensor(
    val id:Int,
    @SerializedName("param.paramName")
    val name:String

)