package com.minimalist.moviedb.data.entity.mapper

import com.minimalist.moviedb.data.entity.MovieDetailEntity
import com.minimalist.moviedb.domain.model.MovieDetail
import javax.inject.Inject

class MovieDetailMapper @Inject constructor(private val genresMapper: GenresMapper,
                                            private val productionCompaniesMapper: ProductionCompaniesMapper,
                                            private val productionCountriesMapper: ProductionCountriesMapper,
                                            private val spokenLanguagesMapper: SpokenLanguagesMapper):
        Mapper<MovieDetailEntity, MovieDetail> {

    override fun mapFromEntity(type: MovieDetailEntity): MovieDetail {
        return MovieDetail(type.adult,
                type.backdropPath,
                type.belongsToCollection,
                type.budget,
                genresMapper.mapFromEntity(type.genres),
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
                spokenLanguagesMapper.mapFromEntity(type.spokenLanguages),
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
                genresMapper.mapToEntity(type.genres),
                type.homepage,
                type.id,
                type.imdbId,
                type.originalLanguage,
                type.originalTitle,
                type.overview,
                type.popularity,
                type.posterPath,
                productionCompaniesMapper.mapToEntity(type.productionCompanies),
                productionCountriesMapper.mapToEntity(type.productionCountries),
                type.releaseDate,
                type.revenue,
                type.runtime,
                spokenLanguagesMapper.mapToEntity(type.spokenLanguages),
                type.status,
                type.tagline,
                type.title,
                type.video,
                type.voteAverage,
                type.voteCount)
    }

}