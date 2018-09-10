package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.ActorDetailEntity
import com.example.hendratay.whatowatch.domain.model.ActorDetail
import javax.inject.Inject

class ActorDetailMapper @Inject constructor(): Mapper<ActorDetailEntity, ActorDetail> {

    override fun mapFromEntity(type: ActorDetailEntity): ActorDetail {
        return ActorDetail(type.birthday,
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

    override fun mapToEntity(type: ActorDetail): ActorDetailEntity {
        return ActorDetailEntity(type.birthday,
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
