package com.example.hendratay.whatowatch.domain.model

// todo
data class ActorResults(val profilePath: String,
                        val adult: Boolean,
                        val id: Int,
                        val knownForMovie: List<MovieResults>?,
                        val knownForTv: List<TvResults>?,
                        val name: String,
                        val popularity: Number)