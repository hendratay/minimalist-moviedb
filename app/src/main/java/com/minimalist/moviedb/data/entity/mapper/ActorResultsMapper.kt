package com.minimalist.moviedb.data.entity.mapper

import com.minimalist.moviedb.data.entity.ActorResultsEntity
import com.minimalist.moviedb.domain.model.ActorResults
import javax.inject.Inject

class ActorResultsMapper @Inject constructor(private val movieResultsMapper: MovieResultsMapper,
                                             private val tvResultsMapper: TvResultsMapper):
        Mapper<ActorResultsEntity, ActorResults> {

    override fun mapFromEntity(type: ActorResultsEntity): ActorResults {
        return ActorResults(type.profilePath,
                type.adult,
                type.id,
                movieResultsMapper.mapFromEntity(type.knownForMovie),
                tvResultsMapper.mapFromEntity(type.knownForTv),
                type.name,
                type.popularity)
    }

    override fun mapToEntity(type: ActorResults): ActorResultsEntity {
        return ActorResultsEntity(type.profilePath,
                type.adult,
                type.id,
                movieResultsMapper.mapToEntity(type.knownForMovie),
                tvResultsMapper.mapToEntity(type.knownForTv),
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
