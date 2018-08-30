package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.SpokenLanguagesEntity
import com.example.hendratay.whatowatch.domain.model.SpokenLanguages
import javax.inject.Inject

class SpokenLanguagesMapper @Inject constructor(): Mapper<SpokenLanguagesEntity, SpokenLanguages> {

    override fun mapFromEntity(type: SpokenLanguagesEntity): SpokenLanguages {
        return SpokenLanguages(type.iso, type.name)
    }

    override fun mapToEntity(type: SpokenLanguages): SpokenLanguagesEntity {
        return SpokenLanguagesEntity(type.iso, type.name)
    }

    fun mapFromEntity(list: List<SpokenLanguagesEntity>): List<SpokenLanguages> {
        return list.map { mapFromEntity(it) }
    }

    fun mapToEntity(list: List<SpokenLanguages>): List<SpokenLanguagesEntity> {
        return list.map { mapToEntity(it) }
    }

}