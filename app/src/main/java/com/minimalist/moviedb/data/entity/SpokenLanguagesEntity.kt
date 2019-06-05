package com.minimalist.moviedb.data.entity

import com.google.gson.annotations.SerializedName

data class SpokenLanguagesEntity(@SerializedName("iso_639_1") val iso: String,
                                 @SerializedName("name") val name: String)