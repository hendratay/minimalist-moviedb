package com.example.hendratay.whatowatch.data.repository

import com.example.hendratay.whatowatch.data.entity.mapper.TvDetailMapper
import com.example.hendratay.whatowatch.data.entity.mapper.TvPopularMapper
import com.example.hendratay.whatowatch.data.repository.datasource.TvDataStoreFactory
import com.example.hendratay.whatowatch.domain.model.TvDetail
import com.example.hendratay.whatowatch.domain.model.TvPopular
import com.example.hendratay.whatowatch.domain.repository.TvRepository
import io.reactivex.Observable
import javax.inject.Inject

class TvDataRepository @Inject constructor(private val factory: TvDataStoreFactory,
                                           private val tvPopularMapper: TvPopularMapper,
                                           private val tvDetailMapper: TvDetailMapper):
        TvRepository {

    override fun getPopularTv(page: Int): Observable<TvPopular> {
        return factory.create().getPopularTv(page)
                .map { tvPopularMapper.mapFromEntity(it) }
    }

    override fun getTvDetail(tvId: Int): Observable<TvDetail> {
        return factory.create().getTvDetail(tvId)
                .map { tvDetailMapper.mapFromEntity(it) }
    }

}