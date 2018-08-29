package com.example.hendratay.whatowatch.domain.interactor

import com.example.hendratay.whatowatch.domain.model.MovieDetail
import com.example.hendratay.whatowatch.domain.repository.MovieRepository
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
