package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.LastEpisodeToAir
import com.example.hendratay.whatowatch.presentation.model.LastEpisodeToAirView
import javax.inject.Inject

class LastEpisodeToAirViewMapper @Inject constructor(): Mapper<LastEpisodeToAirView, LastEpisodeToAir> {

    override fun mapToView(type: LastEpisodeToAir): LastEpisodeToAirView {
        return LastEpisodeToAirView(type.airDate,
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
