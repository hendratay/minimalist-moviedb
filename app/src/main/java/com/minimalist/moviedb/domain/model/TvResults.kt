package com.minimalist.moviedb.domain.model

data class TvResults(val posterPath: String?,
                     val popularity: Number,
                     val id: Int,
                     val backdropPath: String?,
                     val voteAverage: Number,
                     val mediaType: String?,
                     val overview: String,
                     val firstAirDate: String,
                     val originCountry: Array<String>,
                     val genreIds: IntArray,
                     val originalLanguage: String,
                     val voteCount: Int,
                     val name: String,
                     val originalName: String)
