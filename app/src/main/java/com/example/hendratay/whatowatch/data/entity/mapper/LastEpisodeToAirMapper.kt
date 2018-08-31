package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.LastEpisodeToAirEntity
import com.example.hendratay.whatowatch.domain.model.LastEpisodeToAir
import javax.inject.Inject

class LastEpisodeToAirMapper @Inject constructor(): Mapper<LastEpisodeToAirEntity, LastEpisodeToAir> {

    override fun mapFromEntity(type: LastEpisodeToAirEntity): LastEpisodeToAir {
        return LastEpisodeToAir(type.airDate,
                type.episodeNumber,
                type.id,
                type.name,
                type.overview,
                type.productionCode,
                type.seasonNumber,
                type.showId,
                type.stillPath,
                type.voteAverage,
                type.voteCount)
    }

    override fun mapToEntity(type: LastEpisodeToAir): LastEpisodeToAirEntity {
        return LastEpisodeToAirEntity(type.airDate,
                type.episodeNumber,
                type.id,
                type.name,
                type.overview,
                type.productionCode,
                type.seasonNumber,
                type.showId,
                type.stillPath,
                type.voteAverage,
                type.voteCount)
    }

}
