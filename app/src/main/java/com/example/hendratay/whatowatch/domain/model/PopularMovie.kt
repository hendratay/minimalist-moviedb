package com.example.hendratay.whatowatch.domain.model

data class PopularMovie(val page: Int,
                        val results: List<Results>,
                        val totalResults: Int,
                        val totalPages: Int)