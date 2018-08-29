package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.Genre
import com.example.hendratay.whatowatch.presentation.model.GenreView
import javax.inject.Inject

class GenreViewMapper @Inject constructor(): Mapper<GenreView, Genre> {

    override fun mapToView(type: Genre): GenreView {
        return GenreView(type.id, type.name)
    }

    fun mapToView(list: List<Genre>): List<GenreView> {
        return list.map { mapToView(it) }
    }

}