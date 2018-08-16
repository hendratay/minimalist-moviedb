package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.ActorResults
import com.example.hendratay.whatowatch.presentation.model.ActorResultsView
import javax.inject.Inject

// todo
class ActorResultsViewMapper @Inject constructor(): Mapper<ActorResultsView, ActorResults> {

    override fun mapToView(type: ActorResults): ActorResultsView {
        return ActorResultsView(type.profilePath,
                type.adult,
                type.id,
                type.knownForMovie,
                type.knownForTv,
                type.name,
                type.popularity)
    }

    fun mapToView(list: List<ActorResults>): List<ActorResultsView> {
        return list.map { mapToView(it) }
    }

}
