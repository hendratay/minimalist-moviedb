package com.example.hendratay.whatowatch.domain.repository

import com.example.hendratay.whatowatch.domain.model.TvPopular
import io.reactivex.Observable

interface TvRepository {

    fun getPopularTv(page: Int): Observable<TvPopular>

}