package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.PopularActor
import com.example.hendratay.whatowatch.presentation.model.PopularActorView
import javax.inject.Inject

class PopularActorViewMapper @Inject constructor(private val actorResultsViewMapper: ActorResultsViewMapper): Mapper<PopularActorView, PopularActor> {

    override fun mapToView(type: PopularActor): PopularActorView {
        return PopularActorView(type.page, actorResultsViewMapper.mapToView(type.results), type.totalResults, type.totalPages)
    }

}
