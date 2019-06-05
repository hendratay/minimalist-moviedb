package com.minimalist.moviedb.data.entity.mapper

import com.minimalist.moviedb.data.entity.TvDetailEntity
import com.minimalist.moviedb.domain.model.TvDetail
import javax.inject.Inject

class TvDetailMapper @Inject constructor(private val createdByMapper: CreatedByMapper,
                                         private val genresMapper: GenresMapper,
                                         private val lastEpisodeToAirMapper: LastEpisodeToAirMapper,
                                         private val networksMapper: NetworksMapper,
                                         private val productionCompaniesMapper: ProductionCompaniesMapper,
                                         private val seasonsMapper: SeasonsMapper)
    : Mapper<TvDetailEntity, TvDetail> {

    override fun mapFromEntity(type: TvDetailEntity): TvDetail {
        return TvDetail(type.backdropPath,
                createdByMapper.mapFromEntity(type.createdBy),
                type.episodeRunTime,
                type.firstAirDate,
                genresMapper.mapFromEntity(type.genres),
                type.homepage,
                type.id,
                type.inProduction,
                type.languages,
                type.lastAirDate,
                lastEpisodeToAirMapper.mapFromEntity(type.lastEpisodeToAir),
                type.name,
                networksMapper.mapFromEntity(type.networks),
                type.numberOfEpisodes,
                type.numberOfSeasons,
                type.originCountry,
                type.originLanguage,
                type.originName,
                type.overview,
                type.popularity,
                type.posterPath,
                productionCompaniesMapper.mapFromEntity(type.productionCompaniesEntity),
                seasonsMapper.mapFromEntity(type.seasons),
                type.status,
                type.type,
                type.voteAverage,
                type.voteCount)
    }

    override fun mapToEntity(type: TvDetail): TvDetailEntity {
        return TvDetailEntity(type.backdropPath,
                createdByMapper.mapToEntity(type.createdBy),
                type.episodeRunTime,
                type.firstAirDate,
                genresMapper.mapToEntity(type.genres),
                type.homepage,
                type.id,
                type.inProduction,
                type.languages,
                type.lastAirDate,
                lastEpisodeToAirMapper.mapToEntity(type.lastEpisodeToAir),
                type.name,
                networksMapper.mapToEntity(type.networks),
                type.numberOfEpisodes,
                type.numberOfSeasons,
                type.originCountry,
                type.originLanguage,
                type.originName,
                type.overview,
                type.popularity,
                type.posterPath,
                productionCompaniesMapper.mapToEntity(type.productionCompanies),
                seasonsMapper.mapToEntity(type.seasons),
                type.status,
                type.type,
                type.voteAverage,
                type.voteCount)
    }

}
