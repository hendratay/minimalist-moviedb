package com.example.hendratay.whatowatch.domain.model

data class Results(val posterPath: String?,
                   val adult: Boolean,
                   val overview: String,
                   val releaseDate: String,
                   val genreIds: IntArray,
                   val id: Int,
                   val originalTitle: String,
                   val originalLanguage: String,
                   val title: String,
                   val backdropPath: String?,
                   val popularity: Number,
                   val voteCount: Int,
                   val video: Boolean,
                   val voteAverage: Number)