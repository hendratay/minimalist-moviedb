package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.Genres
import com.example.hendratay.whatowatch.presentation.model.GenresView
import javax.inject.Inject

class GenresViewMapper @Inject constructor(): Mapper<GenresView, Genres> {

    override fun mapToView(type: Genres): GenresView {
        return GenresView(type.id, type.name)
    }

    fun mapToView(list: List<Genres>): List<GenresView> {
        return list.map { mapToView(it) }
    }

}