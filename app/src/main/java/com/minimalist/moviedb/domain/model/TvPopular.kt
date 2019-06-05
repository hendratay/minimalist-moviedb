package com.minimalist.moviedb.domain.model

data class TvPopular(val page: Int,
                     val results: List<TvResults>?,
                     val totalResults: Int,
                     val totalPages: Int)
