package com.minimalist.moviedb.domain.model

data class AuthToken(val success: Boolean,
                     val expiresAt: String,
                     val requestToken: String)