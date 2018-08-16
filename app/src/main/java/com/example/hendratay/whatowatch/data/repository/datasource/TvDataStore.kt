package com.example.hendratay.whatowatch.data.repository.datasource

import com.example.hendratay.whatowatch.data.entity.PopularTvEntity
import io.reactivex.Observable

interface TvDataStore {

    fun getPopularTv(page: Int): Observable<PopularTvEntity>

}