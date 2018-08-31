package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.CreatedBy
import com.example.hendratay.whatowatch.presentation.model.CreatedByView
import javax.inject.Inject

class CreatedByViewMapper @Inject constructor(): Mapper<CreatedByView, CreatedBy> {

    override fun mapToView(type: CreatedBy): CreatedByView {
        return CreatedByView(type.id, type.creditId, type.name, type.gender, type.profilePath)
    }

    fun mapToView(list: List<CreatedBy>): List<CreatedByView> {
        return list.map { mapToView(it) }
    }

}
