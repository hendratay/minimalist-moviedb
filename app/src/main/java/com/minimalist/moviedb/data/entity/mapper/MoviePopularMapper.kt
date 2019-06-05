package com.minimalist.moviedb.data.entity.mapper

import com.minimalist.moviedb.data.entity.MoviePopularEntity
import com.minimalist.moviedb.domain.model.MoviePopular
import javax.inject.Inject

class MoviePopularMapper @Inject constructor(private val movieResultsMapper: MovieResultsMapper): Mapper<MoviePopularEntity, MoviePopular> {

    override fun mapFromEntity(type: MoviePopularEntity): MoviePopular {
        return MoviePopular(type.page, movieResultsMapper.mapFromEntity(type.results), type.totalResults, type.totalPages)
    }

    override fun mapToEntity(type: MoviePopular): MoviePopularEntity {
        return MoviePopularEntity(type.page, movieResultsMapper.mapToEntity(type.results), type.totalResults, type.totalPages)
    }

}