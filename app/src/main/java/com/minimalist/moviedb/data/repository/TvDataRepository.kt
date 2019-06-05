package com.minimalist.moviedb.data.repository

import com.example.hendratay.whatowatch.data.entity.mapper.TvDetailMapper
import com.example.hendratay.whatowatch.data.entity.mapper.TvPopularMapper
import com.minimalist.moviedb.data.repository.datasource.TvDataStoreFactory
import com.minimalist.moviedb.domain.model.TvDetail
import com.minimalist.moviedb.domain.model.TvPopular
import com.minimalist.moviedb.domain.repository.TvRepository
import io.reactivex.Observable
import javax.inject.Inject

class TvDataRepository @Inject constructor(private val factory: TvDataStoreFactory,
                                           private val tvPopularMapper: TvPopularMapper,
                                           private val tvDetailMapper: TvDetailMapper):
        TvRepository {

    override fun getTvPopular(page: Int): Observable<TvPopular> {
        return factory.create().getTvPopular(page)
                .map { tvPopularMapper.mapFromEntity(it) }
    }

    override fun getTvDetail(tvId: Int): Observable<TvDetail> {
        return factory.create().getTvDetail(tvId)
                .map { tvDetailMapper.mapFromEntity(it) }
    }

}