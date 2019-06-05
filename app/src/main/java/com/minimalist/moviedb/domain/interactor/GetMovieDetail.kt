package com.minimalist.moviedb.domain.interactor

import com.minimalist.moviedb.domain.model.MovieDetail
import com.minimalist.moviedb.domain.repository.MovieRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetMovieDetail @Inject constructor(private val movieRepository: MovieRepository): UseCase<MovieDetail, GetMovieDetail.Params>() {

    override fun buildUseCaseObservable(params: Params?): Observable<MovieDetail> {
        return movieRepository.getMovieDetail(params!!.movieId)
    }

    class Params(val movieId: Int) {
        companion object {
            fun forMovie(movieId: Int): Params {
                return Params(movieId)
            }
        }
    }

}
