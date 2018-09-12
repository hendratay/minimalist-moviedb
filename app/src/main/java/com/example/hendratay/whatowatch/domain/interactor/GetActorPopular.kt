package com.example.hendratay.whatowatch.domain.interactor

import com.example.hendratay.whatowatch.domain.model.ActorPopular
import com.example.hendratay.whatowatch.domain.repository.ActorRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetActorPopular @Inject constructor(private val actorRepository: ActorRepository): UseCase<ActorPopular, GetActorPopular.Params>() {

    override fun buildUseCaseObservable(params: Params?): Observable<ActorPopular> {
        return actorRepository.getActorPopular(params!!.page)
    }

    class Params(val page: Int) {
        companion object {
            fun forPage(page: Int): Params {
                return Params(page)
            }
        }
    }

}
