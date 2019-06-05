package com.minimalist.moviedb.data.repository

import com.example.hendratay.whatowatch.data.entity.mapper.ActorDetailMapper
import com.example.hendratay.whatowatch.data.entity.mapper.ActorPopularMapper
import com.minimalist.moviedb.data.repository.datasource.ActorDataStoreFactory
import com.minimalist.moviedb.domain.model.ActorDetail
import com.minimalist.moviedb.domain.model.ActorPopular
import com.minimalist.moviedb.domain.repository.ActorRepository
import io.reactivex.Observable
import javax.inject.Inject

class ActorDataRepository @Inject constructor(private val factory: ActorDataStoreFactory,
                                              private val actorPopularMapper: ActorPopularMapper,
                                              private val actorDetailMapper: ActorDetailMapper):
        ActorRepository {

    override fun getActorPopular(page: Int): Observable<ActorPopular> {
        return factory.create().getActorPopular(page)
                .map { actorPopularMapper.mapFromEntity(it) }
    }

    override fun getActorDetail(actorId: Int): Observable<ActorDetail> {
        return factory.create().getActorDetail(actorId)
                .map { actorDetailMapper.mapFromEntity(it) }
    }

}
