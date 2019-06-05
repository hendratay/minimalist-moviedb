package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.ActorDetail
import com.minimalist.moviedb.presentation.model.ActorDetailView
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
