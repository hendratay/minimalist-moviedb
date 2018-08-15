package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.PopularTv
import com.example.hendratay.whatowatch.presentation.model.PopularTvView
import javax.inject.Inject

class PopularTvViewMapper @Inject constructor(private val tvResultsViewMapper: TvResultsViewMapper): Mapper<PopularTvView, PopularTv> {

    override fun mapToView(type: PopularTv): PopularTvView {
        return PopularTvView(type.page, tvResultsViewMapper.mapToView(type.results), type.totalResults, type.totalPages)
    }

}
