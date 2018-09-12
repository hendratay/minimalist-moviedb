package com.example.hendratay.whatowatch.domain.interactor

import com.example.hendratay.whatowatch.domain.model.TvPopular
import com.example.hendratay.whatowatch.domain.repository.TvRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetTvPopular @Inject constructor(private val tvRepository: TvRepository): UseCase<TvPopular, GetTvPopular.Params>() {

    override fun buildUseCaseObservable(params: Params?): Observable<TvPopular> {
        return tvRepository.getTvPopular(params!!.page)
    }

    class Params(val page: Int) {
        companion object {
            fun forPage(page: Int): Params {
                return Params(page)
            }
        }
    }

}