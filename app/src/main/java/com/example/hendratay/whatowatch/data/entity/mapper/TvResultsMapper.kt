package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.TvResultsEntity
import com.example.hendratay.whatowatch.domain.model.TvResults
import javax.inject.Inject

class TvResultsMapper @Inject constructor(): Mapper<TvResultsEntity, TvResults> {

    override fun mapFromEntity(type: TvResultsEntity): TvResults {
        return TvResults(type.posterPath,
                type.popularity,
                type.id,
                type.backdropPath,
                type.voteAverage,
                type.mediaType,
                type.overview,
                type.firstAirDate,
                type.originCountry,
                type.genreIds,
                type.originalLanguage,
                type.voteCount,
                type.name,
                type.originalName)
    }

    override fun mapToEntity(type: TvResults): TvResultsEntity {
        return TvResultsEntity(type.posterPath,
                type.popularity,
                type.id,
                type.backdropPath,
                type.voteAverage,
                type.mediaType,
                type.overview,
                type.firstAirDate,
                type.originCountry,
                type.genreIds,
                type.originalLanguage,
                type.voteCount,
                type.name,
                type.originalName)
    }

    fun mapFromEntity(list: List<TvResultsEntity>?): List<TvResults>? {
        return list?.map { mapFromEntity(it) }
    }

    fun mapToEntity(list: List<TvResults>?): List<TvResultsEntity>? {
        return list?.map { mapToEntity(it) }
    }

}
