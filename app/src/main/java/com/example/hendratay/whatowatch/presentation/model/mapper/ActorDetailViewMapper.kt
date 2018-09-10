package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.ActorDetail
import com.example.hendratay.whatowatch.presentation.model.ActorDetailView
import javax.inject.Inject

class ActorDetailViewMapper @Inject constructor(): Mapper<ActorDetailView, ActorDetail> {

    override fun mapToView(type: ActorDetail): ActorDetailView {
        return ActorDetailView(type.birthday,
                type.knownForDepartment,
                type.deathDay,
                type.id,
                type.name,
                type.alsoKnownAs,
                type.gender,
                type.biography,
                type.popularity,
                type.placeOfBirth,
                type.profilePath,
                type.adult,
                type.imdbId,
                type.homepage)
    }

}
