package com.minimalist.moviedb.data.entity.mapper

import com.minimalist.moviedb.data.entity.ActorPopularEntity
import com.minimalist.moviedb.domain.model.ActorPopular
import javax.inject.Inject

class ActorPopularMapper @Inject constructor(private val actorResultsMapper: ActorResultsMapper): Mapper<ActorPopularEntity, ActorPopular> {

    override fun mapFromEntity(type: ActorPopularEntity): ActorPopular {
        return ActorPopular(type.page, actorResultsMapper.mapFromEntity(type.results), type.totalResults, type.totalPages)
    }

    override fun mapToEntity(type: ActorPopular): ActorPopularEntity {
        return ActorPopularEntity(type.page, actorResultsMapper.mapToEntity(type.results), type.totalResults, type.totalPages)
    }

}
