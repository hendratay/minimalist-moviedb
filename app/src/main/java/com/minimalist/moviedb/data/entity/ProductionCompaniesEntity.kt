package com.minimalist.moviedb.data.entity

import com.google.gson.annotations.SerializedName

data class ProductionCompaniesEntity(@SerializedName("name") val name: String,
                                     @SerializedName("id") val id: Int,
                                     @SerializedName("logo_path") val logoPath: String?,
                                     @SerializedName("origin_country") val originCountry: String)