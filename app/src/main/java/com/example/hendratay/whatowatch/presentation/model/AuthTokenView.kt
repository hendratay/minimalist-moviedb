package com.example.hendratay.whatowatch.presentation.model

data class AuthTokenView(val success: Boolean,
                         val expiresAt: String,
                         val requestToken: String)