package com.minimalist.moviedb.data.entity

import com.google.gson.annotations.SerializedName

data class AccountDetailEntity(@SerializedName("avatar") val avatar: AvatarEntity,
                               @SerializedName("id") val id: Int,
                               @SerializedName("iso_639_1") val languageCode: String,
                               @SerializedName("iso_3166_1") val CountryCode: String,
                               @SerializedName("name") val name: String,
                               @SerializedName("include_adult") val includeAdult: Boolean,
                               @SerializedName("username") val username: String)

data class AvatarEntity(@SerializedName("gravatar") val gravatar: GravatarEntity)

data class GravatarEntity(@SerializedName("hash") val hash: String)
