package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.SeasonsEntity
import com.example.hendratay.whatowatch.domain.model.Seasons
import javax.inject.Inject

class SeasonsMapper @Inject constructor(): Mapper<SeasonsEntity, Seasons> {

    override fun mapFromEntity(type: SeasonsEntity): Seasons {
        return Seasons(type.airDate, type.episodeCount, type.id, type.name, type.overview, type.posterPath, type.seasonNumber)
    }

    override fun mapToEntity(type: Seasons): SeasonsEntity {
        return SeasonsEntity(type.airDate, type.episodeCount, type.id, type.name, type.overview, type.posterPath, type.seasonNumber)
    }

    fun mapFromEntity(list: List<SeasonsEntity>): List<Seasons> {
        return list.map { mapFromEntity(it) }
    }

    fun mapToEntity(list: List<Seasons>): List<SeasonsEntity> {
        return list.map { mapToEntity(it) }
    }

}
