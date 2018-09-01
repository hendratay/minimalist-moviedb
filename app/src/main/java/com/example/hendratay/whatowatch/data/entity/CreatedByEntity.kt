package com.example.hendratay.whatowatch.data.entity

import com.google.gson.annotations.SerializedName

data class CreatedByEntity(@SerializedName("id") val id: Int,
                           @SerializedName("credit_id") val creditId: String,
                           @SerializedName("name") val name: String,
                           @SerializedName("gender") val gender: Int,
                           @SerializedName("profile_path") val profilePath: String?)