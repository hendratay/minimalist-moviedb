package com.example.hendratay.whatowatch.domain.model

data class LastEpisodeToAir(val airDate: String,
                            val episodeNumber: Int,
                            val id: Int,
                            val name: String,
                            val overview: String,
                            val productionCode: String?,
                            val seasonNumber: Int,
                            val showId: Int,
                            val stillPath: String?,
                            val voteAverage: Number,
                            val voteCount: Int)