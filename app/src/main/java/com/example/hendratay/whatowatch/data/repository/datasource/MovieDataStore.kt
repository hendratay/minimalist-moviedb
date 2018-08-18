package com.example.hendratay.whatowatch.data.repository.datasource

import com.example.hendratay.whatowatch.data.entity.MoviePopularEntity
import io.reactivex.Observable

interface MovieDataStore {

    fun getPopularMovie(page: Int): Observable<MoviePopularEntity>

}