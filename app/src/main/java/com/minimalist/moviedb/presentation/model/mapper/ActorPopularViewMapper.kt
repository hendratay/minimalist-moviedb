package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.ActorPopular
import com.minimalist.moviedb.presentation.model.ActorPopularView
import javax.inject.Inject

class ActorPopularViewMapper @Inject constructor(private val actorResultsViewMapper: ActorResultsViewMapper): Mapper<ActorPopularView, ActorPopular> {

    override fun mapToView(type: ActorPopular): ActorPopularView {
        return ActorPopularView(type.page, actorResultsViewMapper.mapToView(type.results), type.totalResults, type.totalPages)
    }

}
