package com.example.hendratay.whatowatch.presentation.model

data class TvResultsView(val posterPath: String?,
                         val popularity: Number,
                         val id: Int,
                         val backdropPath: String?,
                         val voteAverage: Number,
                         val overview: String,
                         val firstAirDate: String,
                         val originCountry: Array<String>,
                         val genreIds: IntArray,
                         val originalLanguage: String,
                         val voteCount: Int,
                         val name: String,
                         val originalName: String)
