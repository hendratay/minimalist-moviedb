package com.minimalist.moviedb.data.repository.datasource

import com.minimalist.moviedb.data.entity.MovieDetailEntity
import com.minimalist.moviedb.data.entity.MoviePopularEntity
import io.reactivex.Observable

interface MovieDataStore {

    fun getMoviePopular(page: Int): Observable<MoviePopularEntity>

    fun getMovieDetail(movieId: Int): Observable<MovieDetailEntity>

}