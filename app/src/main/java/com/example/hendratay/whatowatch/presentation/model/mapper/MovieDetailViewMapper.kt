package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.MovieDetail
import com.example.hendratay.whatowatch.presentation.model.MovieDetailView
import javax.inject.Inject

class MovieDetailViewMapper @Inject constructor(private val genreViewMapper: GenreViewMapper,
                                                private val productionCompaniesViewMapper: ProductionCompaniesViewMapper,
                                                private val productionCountriesViewMapper: ProductionCountriesViewMapper,
                                                private val spokenLanguageViewMapper: SpokenLanguageViewMapper):
        Mapper<MovieDetailView, MovieDetail> {

    override fun mapToView(type: MovieDetail): MovieDetailView {
        return MovieDetailView(type.adult,
                type.backdropPath,
                type.belongsToCollection,
                type.budget,
                genreViewMapper.mapToView(type.genres),
                type.homepage,
                type.id,
                type.imdbId,
                type.originalLangauge,
                type.originalTitle,
                type.overview,
                type.popularity,
                type.posterPath,
                productionCompaniesViewMapper.mapToView(type.productionCompanies),
                productionCountriesViewMapper.mapToView(type.productionCountries),
                type.releaseDate,
                type.revenue,
                type.runtime,
                spokenLanguageViewMapper.mapToView(type.spokenLanguage),
                type.status,
                type.tagline,
                type.title,
                type.video,
                type.voteAverage,
                type.voteCount)
    }

}