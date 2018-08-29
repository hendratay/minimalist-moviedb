package com.example.hendratay.whatowatch.data.repository.datasource

import com.example.hendratay.whatowatch.data.entity.MovieDetailEntity
import com.example.hendratay.whatowatch.data.entity.MoviePopularEntity
import io.reactivex.Observable

interface MovieDataStore {

    fun getPopularMovie(page: Int): Observable<MoviePopularEntity>

    fun getMovieDetail(movieId: Int): Observable<MovieDetailEntity>

}