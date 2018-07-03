package com.example.hendratay.whatowatch.domain.model

data class PopularMovie(val page: Int,
                        val results: Results,
                        val totalResults: Int,
                        val totalPages: Int)