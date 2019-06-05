package com.minimalist.moviedb.domain.repository

import com.minimalist.moviedb.domain.model.TvDetail
import com.minimalist.moviedb.domain.model.TvPopular
import io.reactivex.Observable

interface TvRepository {

    fun getTvPopular(page: Int): Observable<TvPopular>

    fun getTvDetail(tvId: Int): Observable<TvDetail>

}