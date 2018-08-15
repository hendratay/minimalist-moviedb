package com.example.hendratay.whatowatch.domain.model

data class PopularMovie(val page: Int,
                        val results: List<MovieResults>,
                        val totalResults: Int,
                        val totalPages: Int)