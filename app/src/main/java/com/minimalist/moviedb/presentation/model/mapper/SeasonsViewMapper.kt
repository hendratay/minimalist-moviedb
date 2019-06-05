package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.Seasons
import com.minimalist.moviedb.presentation.model.SeasonsView
import javax.inject.Inject

class SeasonsViewMapper @Inject constructor(): Mapper<SeasonsView, Seasons> {

    override fun mapToView(type: Seasons): SeasonsView {
        return SeasonsView(type.airDate, type.episodeCount, type.id, type.name, type.overview, type.posterPath, type.seasonNumber)
    }

    fun mapToView(list: List<Seasons>): List<SeasonsView> {
        return list.map { mapToView(it) }
    }

}
