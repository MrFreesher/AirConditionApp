package com.freesher.airconditionapp.model

import com.google.gson.annotations.SerializedName

data class Measure(
    @SerializedName("values")
    val values:List<Values>

)
data class Values(
    @SerializedName("date")
    val date:String,
    @SerializedName("value")
    val value: Double
)