package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.PopularMovieEntity
import com.example.hendratay.whatowatch.domain.model.PopularMovie
import javax.inject.Inject

class PopularMovieMapper @Inject constructor(private val movieResultsMapper: MovieResultsMapper): Mapper<PopularMovieEntity, PopularMovie> {

    override fun mapFromEntity(type: PopularMovieEntity): PopularMovie {
        return PopularMovie(type.page, movieResultsMapper.mapFromEntity(type.results), type.totalResults, type.totalPages)
    }

    override fun mapToEntity(type: PopularMovie): PopularMovieEntity {
        return PopularMovieEntity(type.page, movieResultsMapper.mapToEntity(type.results), type.totalResults, type.totalPages)
    }

}