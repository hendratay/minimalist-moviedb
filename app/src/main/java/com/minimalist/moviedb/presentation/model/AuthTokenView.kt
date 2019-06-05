package com.minimalist.moviedb.presentation.model

data class AuthTokenView(val success: Boolean,
                         val expiresAt: String,
                         val requestToken: String)