package com.example.hendratay.whatowatch.domain.repository

import com.example.hendratay.whatowatch.domain.model.ActorPopular
import io.reactivex.Observable

interface ActorRepository {

    fun getPopularActor (page: Int): Observable<ActorPopular>

}