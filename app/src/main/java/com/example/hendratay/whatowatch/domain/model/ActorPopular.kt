package com.example.hendratay.whatowatch.domain.model

data class ActorPopular(val page: Int,
                        val results: List<ActorResults>,
                        val totalResults: Int,
                        val totalPages: Int)
