package com.freesher.airconditionapp.model

import com.google.gson.annotations.SerializedName

data class Measure(
    @SerializedName("values.date")
    val date:String,
    @SerializedName("values.value")
    val value:Double

)