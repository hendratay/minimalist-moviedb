package com.example.hendratay.whatowatch.domain.model

data class Seasons(val airDate: String?,
                   val episodeCount: Int,
                   val id: Int,
                   val name: String,
                   val overview: String,
                   val posterPath: String?,
                   val seasonNumber: Int)