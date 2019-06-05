package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.MovieDetail
import com.minimalist.moviedb.presentation.model.MovieDetailView
import javax.inject.Inject

class MovieDetailViewMapper @Inject constructor(private val genresViewMapper: GenresViewMapper,
                                                private val productionCompaniesViewMapper: ProductionCompaniesViewMapper,
                                                private val productionCountriesViewMapper: ProductionCountriesViewMapper,
                                                private val spokenLanguagesViewMapper: SpokenLanguagesViewMapper):
        Mapper<MovieDetailView, MovieDetail> {

    override fun mapToView(type: MovieDetail): MovieDetailView {
        return MovieDetailView(type.adult,
                type.backdropPath,
                type.belongsToCollection,
                type.budget,
                genresViewMapper.mapToView(type.genres),
                type.homepage,
                type.id,
                type.imdbId,
                type.originalLanguage,
                type.originalTitle,
                type.overview,
                type.popularity,
                type.posterPath,
                productionCompaniesViewMapper.mapToView(type.productionCompanies),
                productionCountriesViewMapper.mapToView(type.productionCountries),
                type.releaseDate,
                type.revenue,
                type.runtime,
                spokenLanguagesViewMapper.mapToView(type.spokenLanguages),
                type.status,
                type.tagline,
                type.title,
                type.video,
                type.voteAverage,
                type.voteCount)
    }

}