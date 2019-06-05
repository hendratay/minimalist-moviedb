package com.minimalist.moviedb.presentation.model

data class MoviePopularView(val page: Int,
                            val results: List<MovieResultsView>?,
                            val totalResults: Int,
                            val totalPages: Int)