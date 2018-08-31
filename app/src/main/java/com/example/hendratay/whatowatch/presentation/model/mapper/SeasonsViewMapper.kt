package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.Seasons
import com.example.hendratay.whatowatch.presentation.model.SeasonsView
import javax.inject.Inject

class SeasonsViewMapper @Inject constructor(): Mapper<SeasonsView, Seasons> {

    override fun mapToView(type: Seasons): SeasonsView {
        return SeasonsView(type.airDate, type.episodeCount, type.id, type.name, type.overview, type.posterPath, type.seasonNumber)
    }

    fun mapToView(list: List<Seasons>): List<SeasonsView> {
        return list.map { mapToView(it) }
    }

}
