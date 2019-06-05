package com.minimalist.moviedb.data.repository.datasource

import com.minimalist.moviedb.data.entity.ActorDetailEntity
import com.minimalist.moviedb.data.entity.ActorPopularEntity
import io.reactivex.Observable

interface ActorDataStore {

    fun getActorPopular(page: Int): Observable<ActorPopularEntity>

    fun getActorDetail(actorId: Int): Observable<ActorDetailEntity>

}
