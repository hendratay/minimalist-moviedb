package com.minimalist.moviedb.data.entity

import com.google.gson.annotations.SerializedName

data class AuthTokenEntity(@SerializedName("success") val success: Boolean,
                           @SerializedName("expires_at") val expiresAt: String,
                           @SerializedName("request_token") val requestToken: String)
