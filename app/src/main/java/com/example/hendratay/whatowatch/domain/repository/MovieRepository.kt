package com.example.hendratay.whatowatch.domain.repository

import com.example.hendratay.whatowatch.domain.model.PopularMovie
import io.reactivex.Observable

interface MovieRepository {

    fun getPopularMovie (page: Int): Observable<PopularMovie>

}