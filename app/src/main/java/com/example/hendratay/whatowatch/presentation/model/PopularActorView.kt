package com.example.hendratay.whatowatch.presentation.model

data class PopularActorView(val page: Int,
                            val results: List<ActorResultsView>,
                            val totalResults: Int,
                            val totalPages: Int)
