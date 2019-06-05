package com.minimalist.moviedb.domain.repository

import com.minimalist.moviedb.domain.model.MovieDetail
import com.minimalist.moviedb.domain.model.MoviePopular
import io.reactivex.Observable

interface MovieRepository {

    fun getMoviePopular (page: Int): Observable<MoviePopular>

    fun getMovieDetail (movieId: Int): Observable<MovieDetail>

}