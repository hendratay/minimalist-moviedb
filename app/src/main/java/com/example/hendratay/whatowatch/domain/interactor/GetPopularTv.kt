package com.example.hendratay.whatowatch.domain.interactor

import com.example.hendratay.whatowatch.domain.model.PopularTv
import com.example.hendratay.whatowatch.domain.repository.TvRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetPopularTv @Inject constructor(private val tvRepository: TvRepository): UseCase<PopularTv, GetPopularTv.Params>() {

    override fun buildUseCaseObservable(params: Params?): Observable<PopularTv> {
        return tvRepository.getPopularTv(params!!.page)
    }

    class Params(val page: Int) {
        companion object {
            fun forPage(page: Int): Params {
                return Params(page)
            }
        }
    }

}