package com.example.hendratay.whatowatch.data.repository.datasource

import com.example.hendratay.whatowatch.data.entity.TvDetailEntity
import com.example.hendratay.whatowatch.data.entity.TvPopularEntity
import io.reactivex.Observable

interface TvDataStore {

    fun getTvPopular(page: Int): Observable<TvPopularEntity>

    fun getTvDetail(tvId: Int): Observable<TvDetailEntity>

}