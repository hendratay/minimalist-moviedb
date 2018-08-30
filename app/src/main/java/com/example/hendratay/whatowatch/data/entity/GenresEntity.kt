package com.example.hendratay.whatowatch.data.entity

import com.google.gson.annotations.SerializedName

data class GenresEntity(@SerializedName("id") val id: Int,
                        @SerializedName("name") val name: String)