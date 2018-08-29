package com.example.hendratay.whatowatch.domain.repository

import com.example.hendratay.whatowatch.domain.model.MovieDetail
import com.example.hendratay.whatowatch.domain.model.MoviePopular
import io.reactivex.Observable

interface MovieRepository {

    fun getPopularMovie (page: Int): Observable<MoviePopular>

    fun getMovieDetail (movieId: Int): Observable<MovieDetail>

}