package com.example.hendratay.whatowatch.domain.model

data class AccountDetail(val avatar: Avatar,
                         val id: Int,
                         val languageCode: String,
                         val CountryCode: String,
                         val name: String,
                         val includeAdult: Boolean,
                         val username: String)

data class Avatar(val gravatar: Gravatar)

data class Gravatar(val hash: String)