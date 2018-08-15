package com.example.hendratay.whatowatch.presentation.model

data class PopularTvView(val page: Int,
                         val results: List<TvResultsView>,
                         val totalResults: Int,
                         val totalPages: Int)
