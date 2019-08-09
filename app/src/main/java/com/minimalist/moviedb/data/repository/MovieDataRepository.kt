package com.minimalist.moviedb.data.repository

import com.minimalist.moviedb.data.entity.mapper.MovieDetailMapper
import com.minimalist.moviedb.data.entity.mapper.MoviePopularMapper
import com.minimalist.moviedb.data.repository.datasource.MovieDataStoreFactory
import com.minimalist.moviedb.domain.model.MovieDetail
import com.minimalist.moviedb.domain.model.MoviePopular
import com.minimalist.moviedb.domain.repository.MovieRepository
import io.reactivex.Observable
import javax.inject.Inject

class MovieDataRepository @Inject constructor(private val factory: MovieDataStoreFactory,
                                              private val moviePopularMapper: MoviePopularMapper,
                                              private val movieDetailMapper: MovieDetailMapper):
        MovieRepository {

    override fun getMoviePopular(page: Int): Observable<MoviePopular> {
        return factory.create().getMoviePopular(page)
                .map { moviePopularMapper.mapFromEntity(it) }
    }

    override fun getMovieDetail(movieId: Int): Observable<MovieDetail> {
        return factory.create().getMovieDetail(movieId)
                .map { movieDetailMapper.mapFromEntity(it) }
    }

}
