package com.example.hendratay.whatowatch.domain.interactor

import com.example.hendratay.whatowatch.domain.model.ActorDetail
import com.example.hendratay.whatowatch.domain.repository.ActorRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetActorDetail @Inject constructor(private val actorRepository: ActorRepository): UseCase<ActorDetail, GetActorDetail.Params>() {

    override fun buildUseCaseObservable(params: Params?): Observable<ActorDetail> {
        return actorRepository.getActorDetail(params!!.actorId)
    }

    class Params(val actorId: Int) {
        companion object {
            fun forActor(actorId: Int): Params {
                return Params(actorId)
            }
        }
    }

}
