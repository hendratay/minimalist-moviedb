package com.minimalist.moviedb.data.repository.datasource

import com.minimalist.moviedb.data.entity.TvDetailEntity
import com.minimalist.moviedb.data.entity.TvPopularEntity
import com.minimalist.moviedb.data.remote.TMDBServiceFactory
import io.reactivex.Observable

class TvCloudDataStore: TvDataStore {

    override fun getTvPopular(page: Int): Observable<TvPopularEntity> {
        return TMDBServiceFactory.makeService().tvPopular(page)
    }

    override fun getTvDetail(tvId: Int): Observable<TvDetailEntity> {
        return TMDBServiceFactory.makeService().tvDetail(tvId)
    }

}