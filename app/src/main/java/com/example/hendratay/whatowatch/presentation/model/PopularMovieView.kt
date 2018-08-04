package com.example.hendratay.whatowatch.presentation.model

data class PopularMovieView(val page: Int,
                            val results: ResultsView,
                            val totalResults: Int,
                            val totalPages: Int)