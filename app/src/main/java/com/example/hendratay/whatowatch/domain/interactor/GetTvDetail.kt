package com.example.hendratay.whatowatch.domain.interactor

import com.example.hendratay.whatowatch.domain.model.TvDetail
import com.example.hendratay.whatowatch.domain.repository.TvRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetTvDetail @Inject constructor(private val tvRepository: TvRepository): UseCase<TvDetail, GetTvDetail.Params>() {

    override fun buildUseCaseObservable(params: Params?): Observable<TvDetail> {
        return tvRepository.getTvDetail(params!!.tvId)
    }

    class Params(val tvId: Int) {
        companion object {
            fun forTv(tvId: Int): Params {
                return Params(tvId)
            }
        }
    }

}
