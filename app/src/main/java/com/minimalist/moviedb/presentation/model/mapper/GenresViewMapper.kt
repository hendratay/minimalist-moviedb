package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.Genres
import com.minimalist.moviedb.presentation.model.GenresView
import javax.inject.Inject

class GenresViewMapper @Inject constructor(): Mapper<GenresView, Genres> {

    override fun mapToView(type: Genres): GenresView {
        return GenresView(type.id, type.name)
    }

    fun mapToView(list: List<Genres>): List<GenresView> {
        return list.map { mapToView(it) }
    }

}