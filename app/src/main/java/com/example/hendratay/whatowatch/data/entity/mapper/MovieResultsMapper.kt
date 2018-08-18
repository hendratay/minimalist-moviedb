package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.MovieResultsEntity
import com.example.hendratay.whatowatch.domain.model.MovieResults
import javax.inject.Inject

class MovieResultsMapper @Inject constructor(): Mapper<MovieResultsEntity, MovieResults> {

    override fun mapFromEntity(type: MovieResultsEntity): MovieResults {
        return MovieResults(type.posterPath,
                type.adult,
                type.overview,
                type.releaseDate,
                type.genreIds,
                type.id,
                type.mediaType,
                type.originalTitle,
                type.originalLanguage,
                type.title,
                type.backdropPath,
                type.popularity,
                type.voteCount,
                type.video,
                type.voteAverage)
    }

    override fun mapToEntity(type: MovieResults): MovieResultsEntity {
        return MovieResultsEntity(type.posterPath,
                type.adult,
                type.overview,
                type.releaseDate,
                type.genreIds,
                type.id,
                type.mediaType,
                type.originalTitle,
                type.originalLanguage,
                type.title,
                type.backdropPath,
                type.popularity,
                type.voteCount,
                type.video,
                type.voteAverage)
    }

    fun mapFromEntity(list: List<MovieResultsEntity>?): List<MovieResults>? {
        return list?.map { mapFromEntity(it) }
    }

    fun mapToEntity(list: List<MovieResults>?): List<MovieResultsEntity>? {
        return list?.map { mapToEntity(it) }
    }

}