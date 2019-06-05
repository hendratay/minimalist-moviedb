package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.CreatedBy
import com.minimalist.moviedb.presentation.model.CreatedByView
import javax.inject.Inject

class CreatedByViewMapper @Inject constructor(): Mapper<CreatedByView, CreatedBy> {

    override fun mapToView(type: CreatedBy): CreatedByView {
        return CreatedByView(type.id, type.creditId, type.name, type.gender, type.profilePath)
    }

    fun mapToView(list: List<CreatedBy>): List<CreatedByView> {
        return list.map { mapToView(it) }
    }

}
