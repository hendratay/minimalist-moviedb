package com.example.hendratay.whatowatch.data.repository

import com.example.hendratay.whatowatch.data.entity.mapper.MovieDetailMapper
import com.example.hendratay.whatowatch.data.entity.mapper.MoviePopularMapper
import com.example.hendratay.whatowatch.data.repository.datasource.MovieDataStoreFactory
import com.example.hendratay.whatowatch.domain.model.MovieDetail
import com.example.hendratay.whatowatch.domain.model.MoviePopular
import com.example.hendratay.whatowatch.domain.repository.MovieRepository
import io.reactivex.Observable
import javax.inject.Inject

class MovieDataRepository @Inject constructor(private val factory: MovieDataStoreFactory,
                                              private val moviePopularMapper: MoviePopularMapper,
                                              private val movieDetailMapper: MovieDetailMapper):
        MovieRepository {

    override fun getPopularMovie(page: Int): Observable<MoviePopular> {
        return factory.create().getPopularMovie(page)
                .map { moviePopularMapper.mapFromEntity(it) }
    }

    override fun getMovieDetail(movieId: Int): Observable<MovieDetail> {
        return factory.create().getMovieDetail(movieId)
                .map { movieDetailMapper.mapFromEntity(it) }
    }

}
