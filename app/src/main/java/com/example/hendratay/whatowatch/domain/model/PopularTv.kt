package com.example.hendratay.whatowatch.domain.model

data class PopularTv(val page: Int,
                     val results: List<TvResults>,
                     val totalResults: Int,
                     val totalPages: Int)
