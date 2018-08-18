package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.ActorPopular
import com.example.hendratay.whatowatch.presentation.model.ActorPopularView
import javax.inject.Inject

class ActorPopularViewMapper @Inject constructor(private val actorResultsViewMapper: ActorResultsViewMapper): Mapper<ActorPopularView, ActorPopular> {

    override fun mapToView(type: ActorPopular): ActorPopularView {
        return ActorPopularView(type.page, actorResultsViewMapper.mapToView(type.results), type.totalResults, type.totalPages)
    }

}
