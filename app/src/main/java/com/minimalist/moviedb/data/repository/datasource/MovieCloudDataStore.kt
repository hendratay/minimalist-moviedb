package com.minimalist.moviedb.data.repository.datasource

import com.minimalist.moviedb.data.entity.MovieDetailEntity
import com.minimalist.moviedb.data.entity.MoviePopularEntity
import com.minimalist.moviedb.data.remote.TMDBServiceFactory
import io.reactivex.Observable

class MovieCloudDataStore: MovieDataStore {

    override fun getMoviePopular(page: Int): Observable<MoviePopularEntity> {
        return TMDBServiceFactory.makeService().moviePopular(page)
    }

    override fun getMovieDetail(movieId: Int): Observable<MovieDetailEntity> {
        return TMDBServiceFactory.makeService().movieDetail(movieId)
    }

}