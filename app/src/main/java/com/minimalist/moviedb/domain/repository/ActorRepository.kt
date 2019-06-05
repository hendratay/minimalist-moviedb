package com.minimalist.moviedb.domain.repository

import com.minimalist.moviedb.domain.model.ActorDetail
import com.minimalist.moviedb.domain.model.ActorPopular
import io.reactivex.Observable

interface ActorRepository {

    fun getActorPopular (page: Int): Observable<ActorPopular>

    fun getActorDetail (actorId: Int): Observable<ActorDetail>

}