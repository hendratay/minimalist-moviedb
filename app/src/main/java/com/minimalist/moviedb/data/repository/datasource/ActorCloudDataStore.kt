package com.minimalist.moviedb.data.repository.datasource

import com.minimalist.moviedb.data.entity.ActorDetailEntity
import com.minimalist.moviedb.data.entity.ActorPopularEntity
import com.minimalist.moviedb.data.remote.TMDBServiceFactory
import io.reactivex.Observable

class ActorCloudDataStore: ActorDataStore {

    override fun getActorPopular(page: Int): Observable<ActorPopularEntity> {
        return TMDBServiceFactory.makeService().actorPopular(page)
    }

    override fun getActorDetail(actorId: Int): Observable<ActorDetailEntity> {
        return TMDBServiceFactory.makeService().actorDetail(actorId)
    }

}
