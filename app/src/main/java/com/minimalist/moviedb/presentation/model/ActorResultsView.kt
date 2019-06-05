package com.minimalist.moviedb.presentation.model

data class ActorResultsView(val profilePath: String?,
                            val adult: Boolean,
                            val id: Int,
                            val knowForMovie: List<MovieResultsView>?,
                            val knownForTv: List<TvResultsView>?,
                            val name: String,
                            val popularity: Number)