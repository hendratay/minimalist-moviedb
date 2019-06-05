package com.minimalist.moviedb.data.entity

import com.google.gson.annotations.SerializedName

data class ActorPopularEntity(@SerializedName("page") val page: Int,
                              @SerializedName("results") val results: List<ActorResultsEntity>,
                              @SerializedName("total_results") val totalResults: Int,
                              @SerializedName("total_pages") val totalPages: Int)
