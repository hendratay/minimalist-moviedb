package com.example.hendratay.whatowatch.domain.repository

import com.example.hendratay.whatowatch.domain.model.TvDetail
import com.example.hendratay.whatowatch.domain.model.TvPopular
import io.reactivex.Observable

interface TvRepository {

    fun getTvPopular(page: Int): Observable<TvPopular>

    fun getTvDetail(tvId: Int): Observable<TvDetail>

}