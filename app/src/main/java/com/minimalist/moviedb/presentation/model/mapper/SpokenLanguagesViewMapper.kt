package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.SpokenLanguages
import com.minimalist.moviedb.presentation.model.SpokenLanguagesView
import javax.inject.Inject

class SpokenLanguagesViewMapper @Inject constructor(): Mapper<SpokenLanguagesView, SpokenLanguages> {

    override fun mapToView(type: SpokenLanguages): SpokenLanguagesView {
        return SpokenLanguagesView(type.iso, type.name)
    }

    fun mapToView(list: List<SpokenLanguages>): List<SpokenLanguagesView> {
        return list.map { mapToView(it) }
    }

}