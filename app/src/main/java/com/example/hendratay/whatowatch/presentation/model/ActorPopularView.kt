package com.example.hendratay.whatowatch.presentation.model

data class ActorPopularView(val page: Int,
                            val results: List<ActorResultsView>,
                            val totalResults: Int,
                            val totalPages: Int)
