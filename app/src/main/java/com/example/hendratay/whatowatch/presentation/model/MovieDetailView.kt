package com.example.hendratay.whatowatch.presentation.model

import com.example.hendratay.whatowatch.domain.model.SpokenLanguage

data class MovieDetailView(val adult: Boolean,
                           val backdropPath: String?,
                           val belongsToCollection: Any?,
                           val budget: Int,
                           val genres: List<GenreView>,
                           val homepage: String?,
                           val id: Int,
                           val imdbId: String?,
                           val originalLanguage: String,
                           val originalTitle: String,
                           val overview: String?,
                           val popularity: Number,
                           val posterPath: String?,
                           val productionCompanies: List<ProductionCompaniesView>,
                           val productionCountries: List<ProductionCountriesView>,
                           val releaseDate: String,
                           val revenue: Int,
                           val runtime: Int?,
                           val spokenLanguage: List<SpokenLanguage>,
                           val status: String,
                           val tagline: String?,
                           val title: String,
                           val video: Boolean,
                           val voteAverage: Number,
                           val voteCount: Int)