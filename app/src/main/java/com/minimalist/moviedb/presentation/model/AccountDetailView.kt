package com.minimalist.moviedb.presentation.model

data class AccountDetailView(val avatar: AvatarView,
                             val id: Int,
                             val languageCode: String,
                             val CountryCode: String,
                             val name: String,
                             val includeAdult: Boolean,
                             val username: String)

data class AvatarView(val gravatar: GravatarView)

data class GravatarView(val hash: String)