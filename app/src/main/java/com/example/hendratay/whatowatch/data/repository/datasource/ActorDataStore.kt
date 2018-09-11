package com.example.hendratay.whatowatch.data.repository.datasource

import com.example.hendratay.whatowatch.data.entity.ActorDetailEntity
import com.example.hendratay.whatowatch.data.entity.ActorPopularEntity
import io.reactivex.Observable

interface ActorDataStore {

    fun getPopularActor(page: Int): Observable<ActorPopularEntity>

    fun getActorDetail(actorId: Int): Observable<ActorDetailEntity>

}
