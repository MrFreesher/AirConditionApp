package com.freesher.airconditionapp.model

import com.google.gson.annotations.SerializedName

data class Sensor(
    val id:Int,
    @SerializedName("param")
    val param:Param


)
data class Param( @SerializedName("paramName")
             val name:String
)
