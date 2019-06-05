package com.minimalist.moviedb.presentation.model

data class TvPopularView(val page: Int,
                         val results: List<TvResultsView>?,
                         val totalResults: Int,
                         val totalPages: Int)
