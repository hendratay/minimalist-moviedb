package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.PopularTvEntity
import com.example.hendratay.whatowatch.domain.model.PopularTv
import javax.inject.Inject

class PopularTvMapper @Inject constructor(private val tvResultsMapper: TvResultsMapper): Mapper<PopularTvEntity, PopularTv> {

    override fun mapFromEntity(type: PopularTvEntity): PopularTv {
        return PopularTv(type.page, tvResultsMapper.mapFromEntity(type.results), type.totalResults, type.totalPages)
    }

    override fun mapToEntity(type: PopularTv): PopularTvEntity {
        return PopularTvEntity(type.page, tvResultsMapper.mapToEntity(type.results), type.totalResults, type.totalPages)
    }

}
