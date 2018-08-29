package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.MovieDetailEntity
import com.example.hendratay.whatowatch.domain.model.MovieDetail
import javax.inject.Inject

class MovieDetailMapper @Inject constructor(private val genreMapper: GenreMapper,
                                            private val productionCompaniesMapper: ProductionCompaniesMapper,
                                            private val productionCountriesMapper: ProductionCountriesMapper,
                                            private val spokenLanguageMapper: SpokenLanguageMapper):
        Mapper<MovieDetailEntity, MovieDetail> {

    override fun mapFromEntity(type: MovieDetailEntity): MovieDetail {
        return MovieDetail(type.adult,
                type.backdropPath,
                type.belongsToCollection,
                type.budget,
                genreMapper.mapFromEntity(type.genre),
                type.homepage,
                type.id,
                type.imdbId,
                type.originalLanguage,
                type.originalTitle,
                type.overview,
                type.popularity,
                type.posterPath,
                productionCompaniesMapper.mapFromEntity(type.productionCompanies),
                productionCountriesMapper.mapFromEntity(type.productionCountries),
                type.releaseDate,
                type.revenue,
                type.runtime,
                spokenLanguageMapper.mapFromEntity(type.spokenLanguage),
                type.status,
                type.tagline,
                type.title,
                type.video,
                type.voteAverage,
                type.voteCount)
    }

    override fun mapToEntity(type: MovieDetail): MovieDetailEntity {
        return MovieDetailEntity(type.adult,
                type.backdropPath,
                type.belongsToCollection,
                type.budget,
                genreMapper.mapToEntity(type.genres),
                type.homepage,
                type.id,
                type.imdbId,
                type.originalLangauge,
                type.originalTitle,
                type.overview,
                type.popularity,
                type.posterPath,
                productionCompaniesMapper.mapToEntity(type.productionCompanies),
                productionCountriesMapper.mapToEntity(type.productionCountries),
                type.releaseDate,
                type.revenue,
                type.runtime,
                spokenLanguageMapper.mapToEntity(type.spokenLanguage),
                type.status,
                type.tagline,
                type.title,
                type.video,
                type.voteAverage,
                type.voteCount)
    }

}