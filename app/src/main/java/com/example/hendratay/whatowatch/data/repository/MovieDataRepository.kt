package com.example.hendratay.whatowatch.data.repository

import com.example.hendratay.whatowatch.data.entity.mapper.MoviePopularMapper
import com.example.hendratay.whatowatch.data.repository.datasource.MovieDataStoreFactory
import com.example.hendratay.whatowatch.domain.model.MoviePopular
import com.example.hendratay.whatowatch.domain.repository.MovieRepository
import io.reactivex.Observable
import javax.inject.Inject

class MovieDataRepository @Inject constructor(private val factory: MovieDataStoreFactory,
                                              private val moviePopularMapper: MoviePopularMapper):
        MovieRepository {

    override fun getPopularMovie(page: Int): Observable<MoviePopular> {
        return factory.create().getPopularMovie(page)
                .map { moviePopularMapper.mapFromEntity(it) }
    }

}
