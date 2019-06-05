package com.minimalist.moviedb.data.entity

import com.google.gson.annotations.SerializedName

data class TvPopularEntity(@SerializedName("page") val page: Int,
                           @SerializedName("results") val results: List<TvResultsEntity>?,
                           @SerializedName("total_results") val totalResults: Int,
                           @SerializedName("total_pages") val totalPages: Int)
