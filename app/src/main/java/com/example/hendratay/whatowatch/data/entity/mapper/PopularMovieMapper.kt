package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.PopularMovieEntity
import com.example.hendratay.whatowatch.domain.model.PopularMovie
import javax.inject.Inject

class PopularMovieMapper @Inject constructor(private val resultsMapper: ResultsMapper): Mapper<PopularMovieEntity, PopularMovie> {

    override fun mapFromEntity(type: PopularMovieEntity): PopularMovie {
        return PopularMovie(type.page, resultsMapper.mapFromEntity(type.results), type.totalResults, type.totalPages)
    }

    override fun mapToEntity(type: PopularMovie): PopularMovieEntity {
        return PopularMovieEntity(type.page, resultsMapper.mapToEntity(type.results), type.totalResults, type.totalPages)
    }

}