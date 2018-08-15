package com.example.hendratay.whatowatch.data.entity

import com.google.gson.annotations.SerializedName

data class PopularMovieEntity(@SerializedName("page") val page: Int,
                              @SerializedName("results") val results: List<MovieResultsEntity>,
                              @SerializedName("total_results") val totalResults: Int,
                              @SerializedName("total_pages") val totalPages: Int)
