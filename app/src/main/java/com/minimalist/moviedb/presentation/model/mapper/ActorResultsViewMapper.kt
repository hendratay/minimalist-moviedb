package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.ActorResults
import com.minimalist.moviedb.presentation.model.ActorResultsView
import javax.inject.Inject

class ActorResultsViewMapper @Inject constructor(private val movieResultsViewMapper: MovieResultsViewMapper,
                                                 private val tvResultsViewMapper: TvResultsViewMapper):
        Mapper<ActorResultsView, ActorResults> {

    override fun mapToView(type: ActorResults): ActorResultsView {
        return ActorResultsView(type.profilePath,
                type.adult,
                type.id,
                movieResultsViewMapper.mapToView(type.knownForMovie),
                tvResultsViewMapper.mapToView(type.knownForTv),
                type.name,
                type.popularity)
    }

    fun mapToView(list: List<ActorResults>): List<ActorResultsView> {
        return list.map { mapToView(it) }
    }

}
