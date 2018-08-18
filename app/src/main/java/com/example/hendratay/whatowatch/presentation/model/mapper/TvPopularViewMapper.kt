package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.TvPopular
import com.example.hendratay.whatowatch.presentation.model.TvPopularView
import javax.inject.Inject

class TvPopularViewMapper @Inject constructor(private val tvResultsViewMapper: TvResultsViewMapper): Mapper<TvPopularView, TvPopular> {

    override fun mapToView(type: TvPopular): TvPopularView {
        return TvPopularView(type.page, tvResultsViewMapper.mapToView(type.results), type.totalResults, type.totalPages)
    }

}
