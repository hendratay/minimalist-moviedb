package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.ResultsEntity
import com.example.hendratay.whatowatch.domain.model.Results

class ResultsMapper: Mapper<ResultsEntity, Results> {

    override fun mapFromEntity(type: ResultsEntity): Results {
        return Results(type.posterPath,
                type.adult,
                type.overview,
                type.releaseDate,
                type.genreIds,
                type.id,
                type.originalTitle,
                type.originalLanguage,
                type.title,
                type.backdropPath,
                type.popularity,
                type.voteCount,
                type.video,
                type.voteAverage)
    }

    override fun mapToEntity(type: Results): ResultsEntity {
        return ResultsEntity(type.posterPath,
                type.adult,
                type.overview,
                type.releaseDate,
                type.genreIds,
                type.id,
                type.originalTitle,
                type.originalLanguage,
                type.title,
                type.backdropPath,
                type.popularity,
                type.voteCount,
                type.video,
                type.voteAverage)
    }

    fun mapFromEntity(list: List<ResultsEntity>): List<Results> {
        return list.map { mapFromEntity(it) }
    }

    fun mapToEntity(list: List<Results>): List<ResultsEntity> {
        return list.map { mapToEntity(it) }
    }

}