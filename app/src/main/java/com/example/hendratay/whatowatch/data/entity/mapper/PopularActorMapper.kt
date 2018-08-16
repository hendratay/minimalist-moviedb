package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.PopularActorEntity
import com.example.hendratay.whatowatch.domain.model.PopularActor
import javax.inject.Inject

class PopularActorMapper @Inject constructor(private val actorResultsMapper: ActorResultsMapper): Mapper<PopularActorEntity, PopularActor> {

    override fun mapFromEntity(type: PopularActorEntity): PopularActor {
        return PopularActor(type.page, actorResultsMapper.mapFromEntity(type.results), type.totalResults, type.totalPages)
    }

    override fun mapToEntity(type: PopularActor): PopularActorEntity {
        return PopularActorEntity(type.page, actorResultsMapper.mapToEntity(type.results), type.totalResults, type.totalPages)
    }

}
