package com.example.hendratay.whatowatch.data.entity

import com.google.gson.annotations.SerializedName

data class ActorResultsEntity(@SerializedName("profile_path") val profilePath: String,
                              @SerializedName("adult") val adult: Boolean,
                              @SerializedName("id") val id: Int,
                              @SerializedName("known_for") val knownForMovie: List<MovieResultsEntity>?,
                              @SerializedName("known_for") val knownForTv: List<TvResultsEntity>?,
                              @SerializedName("name") val name: String,
                              @SerializedName("popularity") val popularity: Number)
