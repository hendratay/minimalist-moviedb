package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.GenresEntity
import com.example.hendratay.whatowatch.domain.model.Genres
import javax.inject.Inject

class GenresMapper @Inject constructor(): Mapper<GenresEntity, Genres> {

    override fun mapFromEntity(type: GenresEntity): Genres {
        return Genres(type.id, type.name)
    }

    override fun mapToEntity(type: Genres): GenresEntity {
        return GenresEntity(type.id, type.name)
    }

    fun mapFromEntity(list: List<GenresEntity>): List<Genres> {
        return list.map { mapFromEntity(it) }
    }

    fun mapToEntity(list: List<Genres>): List<GenresEntity> {
        return list.map { mapToEntity(it) }
    }

}