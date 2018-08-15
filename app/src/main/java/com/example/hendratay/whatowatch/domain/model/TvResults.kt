package com.example.hendratay.whatowatch.domain.model

data class TvResults(val posterPath: String?,
                     val popularity: Number,
                     val id: Int,
                     val backdropPath: String?,
                     val voteAverage: Number,
                     val overview: String,
                     val firstAirDate: String,
                     val originCountry: IntArray,
                     val genreIds: IntArray,
                     val originalLanguage: String,
                     val voteCount: Int,
                     val name: String,
                     val originalName: String)
