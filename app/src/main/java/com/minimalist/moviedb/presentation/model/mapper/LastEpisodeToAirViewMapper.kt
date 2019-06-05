package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.LastEpisodeToAir
import com.minimalist.moviedb.presentation.model.LastEpisodeToAirView
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
