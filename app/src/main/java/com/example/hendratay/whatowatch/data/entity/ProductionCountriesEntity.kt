package com.example.hendratay.whatowatch.data.entity

import com.google.gson.annotations.SerializedName

data class ProductionCountriesEntity(@SerializedName("iso_3166_1") val iso: String,
                                     @SerializedName("name") val name: String)
