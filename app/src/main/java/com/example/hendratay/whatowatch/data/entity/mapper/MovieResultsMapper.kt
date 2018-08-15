package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.MovieResultsEntity
import com.example.hendratay.whatowatch.domain.model.Results
import javax.inject.Inject

class ResultsMapper @Inject constructor(): Mapper<MovieResultsEntity, Results> {

    override fun mapFromEntity(type: MovieResultsEntity): Results {
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

    override fun mapToEntity(type: Results): MovieResultsEntity {
        return MovieResultsEntity(type.posterPath,
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

    fun mapFromEntity(list: List<MovieResultsEntity>): List<Results> {
        return list.map { mapFromEntity(it) }
    }

    fun mapToEntity(list: List<Results>): List<MovieResultsEntity> {
        return list.map { mapToEntity(it) }
    }

}