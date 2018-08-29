package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.SpokenLanguage
import com.example.hendratay.whatowatch.presentation.model.SpokenLanguageView
import javax.inject.Inject

class SpokenLanguageViewMapper @Inject constructor(): Mapper<SpokenLanguageView, SpokenLanguage> {

    override fun mapToView(type: SpokenLanguage): SpokenLanguageView {
        return SpokenLanguageView(type.iso, type.name)
    }

    fun mapToView(list: List<SpokenLanguage>): List<SpokenLanguageView> {
        return list.map { mapToView(it) }
    }

}