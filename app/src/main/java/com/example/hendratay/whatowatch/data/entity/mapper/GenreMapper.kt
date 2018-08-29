package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.GenreEntity
import com.example.hendratay.whatowatch.domain.model.Genre
import javax.inject.Inject

class GenreMapper @Inject constructor(): Mapper<GenreEntity, Genre> {

    override fun mapFromEntity(type: GenreEntity): Genre {
        return Genre(type.id, type.name)
    }

    override fun mapToEntity(type: Genre): GenreEntity {
        return GenreEntity(type.id, type.name)
    }

    fun mapFromEntity(list: List<GenreEntity>): List<Genre> {
        return list.map { mapFromEntity(it) }
    }

    fun mapToEntity(list: List<Genre>): List<GenreEntity> {
        return list.map { mapToEntity(it) }
    }

}