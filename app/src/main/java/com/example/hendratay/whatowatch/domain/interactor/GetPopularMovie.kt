package com.example.hendratay.whatowatch.domain.interactor

import com.example.hendratay.whatowatch.domain.model.PopularMovie
import com.example.hendratay.whatowatch.domain.repository.MovieRepository
import io.reactivex.Observable

class GetPopularMovie(val movieRepository: MovieRepository): UseCase<PopularMovie, GetPopularMovie.Params>() {

    override fun buildUseCaseObservable(params: Params?): Observable<PopularMovie> {
        return movieRepository.getPopularMovie(params!!.page)
    }

    class Params(val page: Int) {
        companion object {
            fun forPage(page: Int): Params {
                return forPage(page)
            }
        }
    }

}