package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.TvPopular
import com.minimalist.moviedb.presentation.model.TvPopularView
import javax.inject.Inject

class TvPopularViewMapper @Inject constructor(private val tvResultsViewMapper: TvResultsViewMapper): Mapper<TvPopularView, TvPopular> {

    override fun mapToView(type: TvPopular): TvPopularView {
        return TvPopularView(type.page, tvResultsViewMapper.mapToView(type.results), type.totalResults, type.totalPages)
    }

}
