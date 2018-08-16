package com.example.hendratay.whatowatch.data.repository

import com.example.hendratay.whatowatch.data.entity.mapper.PopularTvMapper
import com.example.hendratay.whatowatch.data.repository.datasource.TvDataStoreFactory
import com.example.hendratay.whatowatch.domain.model.PopularTv
import com.example.hendratay.whatowatch.domain.repository.TvRepository
import io.reactivex.Observable
import javax.inject.Inject

class TvDataRepository @Inject constructor(private val factory: TvDataStoreFactory,
                                           private val popularTvMapper: PopularTvMapper):
        TvRepository {

    override fun getPopularTv(page: Int): Observable<PopularTv> {
        return factory.create().getPopularTv(page)
                .map { popularTvMapper.mapFromEntity(it) }
    }

}