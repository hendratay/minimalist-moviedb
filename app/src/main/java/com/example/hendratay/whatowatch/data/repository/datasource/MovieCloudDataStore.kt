package com.example.hendratay.whatowatch.data.repository.datasource

import com.example.hendratay.whatowatch.data.entity.MovieDetailEntity
import com.example.hendratay.whatowatch.data.entity.MoviePopularEntity
import com.example.hendratay.whatowatch.data.remote.TMDBServiceFactory
import io.reactivex.Observable

class MovieCloudDataStore: MovieDataStore {

    override fun getPopularMovie(page: Int): Observable<MoviePopularEntity> {
        return TMDBServiceFactory.makeService().popularMovie(page)
    }

    override fun getMovieDetail(movieId: Int): Observable<MovieDetailEntity> {
        return TMDBServiceFactory.makeService().movieDetail(movieId)
    }

}