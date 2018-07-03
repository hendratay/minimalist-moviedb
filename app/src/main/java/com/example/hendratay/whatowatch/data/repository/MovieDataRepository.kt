package com.example.hendratay.whatowatch.data.repository

import com.example.hendratay.whatowatch.data.entity.mapper.PopularMovieMapper
import com.example.hendratay.whatowatch.data.repository.datasource.MovieDataStoreFactory
import com.example.hendratay.whatowatch.domain.model.PopularMovie
import com.example.hendratay.whatowatch.domain.repository.MovieRepository
import io.reactivex.Observable

class MovieDataRepository(val factory: MovieDataStoreFactory,
                          val popularMovieMapper: PopularMovieMapper):
        MovieRepository {

    override fun getPopularMovie(page: Int): Observable<PopularMovie> {
        return factory.create().getPopularMovie(page)
                .map { popularMovieMapper.mapFromEntity(it) }
    }

}
