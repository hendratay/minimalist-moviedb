package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.PopularMovie
import com.example.hendratay.whatowatch.presentation.model.PopularMovieView
import javax.inject.Inject

class PopularMovieViewMapper @Inject constructor(private val resultsViewMapper: ResultsViewMapper): Mapper<PopularMovieView, PopularMovie> {

    override fun mapToView(type: PopularMovie): PopularMovieView {
        return PopularMovieView(type.page, resultsViewMapper.mapToView(type.results), type.totalResults, type.totalPages)
    }

}