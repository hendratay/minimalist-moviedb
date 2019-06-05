package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.TvDetail
import com.minimalist.moviedb.presentation.model.TvDetailView
import javax.inject.Inject

class TvDetailViewMapper @Inject constructor(private val createdByViewMapper: CreatedByViewMapper,
                                             private val genresViewMapper: GenresViewMapper,
                                             private val lastEpisodeToAirViewMapper: LastEpisodeToAirViewMapper,
                                             private val networksViewMapper: NetworksViewMapper,
                                             private val productionCompaniesViewMapper: ProductionCompaniesViewMapper,
                                             private val seasonsViewMapper: SeasonsViewMapper):
        Mapper<TvDetailView, TvDetail> {

    override fun mapToView(type: TvDetail): TvDetailView {
        return TvDetailView(type.backdropPath,
                createdByViewMapper.mapToView(type.createdBy),
                type.episodeRunTime,
                type.firstAirDate,
                genresViewMapper.mapToView(type.genres),
                type.homepage,
                type.id,
                type.inProduction,
                type.languages,
                type.lastAirDate,
                lastEpisodeToAirViewMapper.mapToView(type.lastEpisodeToAir),
                type.name,
                networksViewMapper.mapToView(type.networks),
                type.numberOfEpisodes,
                type.numberOfSeasons,
                type.originCountry,
                type.originLanguage,
                type.originName,
                type.overview,
                type.popularity,
                type.posterPath,
                productionCompaniesViewMapper.mapToView(type.productionCompanies),
                seasonsViewMapper.mapToView(type.seasons),
                type.status,
                type.type,
                type.voteAverage,
                type.voteCount)
    }

}
