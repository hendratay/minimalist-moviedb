package com.minimalist.moviedb.data.entity

import com.google.gson.annotations.SerializedName

data class ProductionCountriesEntity(@SerializedName("iso_3166_1") val iso: String,
                                     @SerializedName("name") val name: String)
