package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.MoviePopular
import com.example.hendratay.whatowatch.presentation.model.MoviePopularView
import javax.inject.Inject

class MoviePopularViewMapper @Inject constructor(private val movieResultsViewMapper: MovieResultsViewMapper): Mapper<MoviePopularView, MoviePopular> {

    override fun mapToView(type: MoviePopular): MoviePopularView {
        return MoviePopularView(type.page, movieResultsViewMapper.mapToView(type.results), type.totalResults, type.totalPages)
    }

}