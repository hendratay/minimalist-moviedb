package com.example.hendratay.whatowatch.data.repository.datasource

import com.example.hendratay.whatowatch.data.entity.TvPopularEntity
import io.reactivex.Observable

interface TvDataStore {

    fun getPopularTv(page: Int): Observable<TvPopularEntity>

}