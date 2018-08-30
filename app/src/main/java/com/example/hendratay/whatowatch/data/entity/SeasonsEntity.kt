package com.example.hendratay.whatowatch.data.entity

import com.google.gson.annotations.SerializedName

data class SeasonsEntity(@SerializedName("air_date") val airDate: String,
                         @SerializedName("episode_count") val episodeCount: Int,
                         @SerializedName("id") val id: Int,
                         @SerializedName("name") val name: String,
                         @SerializedName("overview") val overview: String,
                         @SerializedName("poster_path") val posterPath: String,
                         @SerializedName("season_number") val seasonNumber: Int)