package com.example.hendratay.whatowatch.data.repository

import com.example.hendratay.whatowatch.data.entity.mapper.TvPopularMapper
import com.example.hendratay.whatowatch.data.repository.datasource.TvDataStoreFactory
import com.example.hendratay.whatowatch.domain.model.TvPopular
import com.example.hendratay.whatowatch.domain.repository.TvRepository
import io.reactivex.Observable
import javax.inject.Inject

class TvDataRepository @Inject constructor(private val factory: TvDataStoreFactory,
                                           private val tvPopularMapper: TvPopularMapper):
        TvRepository {

    override fun getPopularTv(page: Int): Observable<TvPopular> {
        return factory.create().getPopularTv(page)
                .map { tvPopularMapper.mapFromEntity(it) }
    }

}