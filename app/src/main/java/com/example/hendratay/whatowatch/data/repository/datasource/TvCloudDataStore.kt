package com.example.hendratay.whatowatch.data.repository.datasource

import com.example.hendratay.whatowatch.data.entity.TvDetailEntity
import com.example.hendratay.whatowatch.data.entity.TvPopularEntity
import com.example.hendratay.whatowatch.data.remote.TMDBServiceFactory
import io.reactivex.Observable

class TvCloudDataStore: TvDataStore {

    override fun getTvPopular(page: Int): Observable<TvPopularEntity> {
        return TMDBServiceFactory.makeService().tvPopular(page)
    }

    override fun getTvDetail(tvId: Int): Observable<TvDetailEntity> {
        return TMDBServiceFactory.makeService().tvDetail(tvId)
    }

}