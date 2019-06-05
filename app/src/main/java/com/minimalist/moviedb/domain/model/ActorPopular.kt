package com.minimalist.moviedb.domain.model

data class ActorPopular(val page: Int,
                        val results: List<ActorResults>,
                        val totalResults: Int,
                        val totalPages: Int)
