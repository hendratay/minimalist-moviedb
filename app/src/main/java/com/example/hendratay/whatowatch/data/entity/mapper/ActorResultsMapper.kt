package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.ActorResultsEntity
import com.example.hendratay.whatowatch.domain.model.ActorResults
import javax.inject.Inject

// todo
class ActorResultsMapper @Inject constructor(private val movieResultsMapper: MovieResultsMapper): Mapper<ActorResultsEntity, ActorResults> {

    override fun mapFromEntity(type: ActorResultsEntity): ActorResults {
        return ActorResults(type.profilePath,
                type.adult,
                type.id,
                type.knownForMovie,
                type.knownForTv,
                type.name,
                type.popularity)
    }

    override fun mapToEntity(type: ActorResults): ActorResultsEntity {
        return ActorResultsEntity(type.profilePath,
                type.adult,
                type.id,
                type.knownForMovie,
                type.knownForTv,
                type.name,
                type.popularity)
    }

    fun mapFromEntity(list: List<ActorResultsEntity>): List<ActorResults> {
        return list.map { mapFromEntity(it) }
    }

    fun mapToEntity(list: List<ActorResults>): List<ActorResultsEntity> {
        return list.map { mapToEntity(it) }
    }

}
