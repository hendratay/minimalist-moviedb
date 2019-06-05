package com.minimalist.moviedb.data.entity

import com.google.gson.annotations.SerializedName

data class LastEpisodeToAirEntity(@SerializedName("air_date") val airDate: String,
                                  @SerializedName("episode_number") val episodeNumber: Int,
                                  @SerializedName("id") val id: Int,
                                  @SerializedName("name") val name: String,
                                  @SerializedName("overview") val overview: String,
                                  @SerializedName("production_code") val productionCode: String?,
                                  @SerializedName("season_number") val seasonNumber: Int,
                                  @SerializedName("show_id") val showId: Int,
                                  @SerializedName("still_path") val stillPath: String?,
                                  @SerializedName("vote_average") val voteAverage: Number,
                                  @SerializedName("vote_count") val voteCount: Int)