package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.SpokenLanguageEntity
import com.example.hendratay.whatowatch.domain.model.SpokenLanguage
import javax.inject.Inject

class SpokenLanguageMapper @Inject constructor(): Mapper<SpokenLanguageEntity, SpokenLanguage> {

    override fun mapFromEntity(type: SpokenLanguageEntity): SpokenLanguage {
        return SpokenLanguage(type.iso, type.name)
    }

    override fun mapToEntity(type: SpokenLanguage): SpokenLanguageEntity {
        return SpokenLanguageEntity(type.iso, type.name)
    }

    fun mapFromEntity(list: List<SpokenLanguageEntity>): List<SpokenLanguage> {
        return list.map { mapFromEntity(it) }
    }

    fun mapToEntity(list: List<SpokenLanguage>): List<SpokenLanguageEntity> {
        return list.map { mapToEntity(it) }
    }

}