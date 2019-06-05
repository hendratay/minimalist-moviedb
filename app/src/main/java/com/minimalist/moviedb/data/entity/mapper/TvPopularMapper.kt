package com.minimalist.moviedb.data.entity.mapper

import com.minimalist.moviedb.data.entity.TvPopularEntity
import com.minimalist.moviedb.domain.model.TvPopular
import javax.inject.Inject

class TvPopularMapper @Inject constructor(private val tvResultsMapper: TvResultsMapper): Mapper<TvPopularEntity, TvPopular> {

    override fun mapFromEntity(type: TvPopularEntity): TvPopular {
        return TvPopular(type.page, tvResultsMapper.mapFromEntity(type.results), type.totalResults, type.totalPages)
    }

    override fun mapToEntity(type: TvPopular): TvPopularEntity {
        return TvPopularEntity(type.page, tvResultsMapper.mapToEntity(type.results), type.totalResults, type.totalPages)
    }

}
