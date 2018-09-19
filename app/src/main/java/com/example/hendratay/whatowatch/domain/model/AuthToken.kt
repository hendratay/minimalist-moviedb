package com.example.hendratay.whatowatch.domain.model

data class AuthToken(val success: Boolean,
                     val expiresAt: String,
                     val requestToken: String)