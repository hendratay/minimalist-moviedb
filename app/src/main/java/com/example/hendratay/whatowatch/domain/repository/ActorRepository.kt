package com.example.hendratay.whatowatch.domain.repository

import com.example.hendratay.whatowatch.domain.model.ActorDetail
import com.example.hendratay.whatowatch.domain.model.ActorPopular
import io.reactivex.Observable

interface ActorRepository {

    fun getActorPopular (page: Int): Observable<ActorPopular>

    fun getActorDetail (actorId: Int): Observable<ActorDetail>

}