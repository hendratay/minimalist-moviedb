package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.MoviePopular
import com.minimalist.moviedb.presentation.model.MoviePopularView
import javax.inject.Inject

class MoviePopularViewMapper @Inject constructor(private val movieResultsViewMapper: MovieResultsViewMapper): Mapper<MoviePopularView, MoviePopular> {

    override fun mapToView(type: MoviePopular): MoviePopularView {
        return MoviePopularView(type.page, movieResultsViewMapper.mapToView(type.results), type.totalResults, type.totalPages)
    }

}