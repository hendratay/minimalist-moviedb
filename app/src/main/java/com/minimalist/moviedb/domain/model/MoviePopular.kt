package com.minimalist.moviedb.domain.model

data class MoviePopular(val page: Int,
                        val results: List<MovieResults>?,
                        val totalResults: Int,
                        val totalPages: Int)