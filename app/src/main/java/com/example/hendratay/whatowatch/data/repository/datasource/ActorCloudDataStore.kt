package com.example.hendratay.whatowatch.data.repository.datasource

import com.example.hendratay.whatowatch.data.entity.ActorDetailEntity
import com.example.hendratay.whatowatch.data.entity.ActorPopularEntity
import com.example.hendratay.whatowatch.data.remote.TMDBServiceFactory
import io.reactivex.Observable

class ActorCloudDataStore: ActorDataStore {

    override fun getActorPopular(page: Int): Observable<ActorPopularEntity> {
        return TMDBServiceFactory.makeService().actorPopular(page)
    }

    override fun getActorDetail(actorId: Int): Observable<ActorDetailEntity> {
        return TMDBServiceFactory.makeService().actorDetail(actorId)
    }

}
