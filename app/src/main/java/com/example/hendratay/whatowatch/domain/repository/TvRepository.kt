package com.example.hendratay.whatowatch.domain.repository

import com.example.hendratay.whatowatch.domain.model.PopularTv
import io.reactivex.Observable

interface TvRepository {

    fun getPopularTv(page: Int): Observable<PopularTv>

}