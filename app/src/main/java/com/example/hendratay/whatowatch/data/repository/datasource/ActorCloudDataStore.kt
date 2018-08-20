package com.example.hendratay.whatowatch.data.repository.datasource

import com.example.hendratay.whatowatch.data.entity.ActorPopularEntity
import com.example.hendratay.whatowatch.data.remote.TMDBServiceFactory
import io.reactivex.Observable


class ActorCloudDataStore: ActorDataStore {

    override fun getPopularActor(page: Int): Observable<ActorPopularEntity> {
        return TMDBServiceFactory.makeService().popularActor(page)
    }

}
