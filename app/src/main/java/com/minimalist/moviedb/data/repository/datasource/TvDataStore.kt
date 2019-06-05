package com.minimalist.moviedb.data.repository.datasource

import com.minimalist.moviedb.data.entity.TvDetailEntity
import com.minimalist.moviedb.data.entity.TvPopularEntity
import io.reactivex.Observable

interface TvDataStore {

    fun getTvPopular(page: Int): Observable<TvPopularEntity>

    fun getTvDetail(tvId: Int): Observable<TvDetailEntity>

}