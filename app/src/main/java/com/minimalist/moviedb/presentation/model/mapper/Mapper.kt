package com.minimalist.moviedb.presentation.model.mapper

interface Mapper<V, D> {

    fun mapToView(type: D): V

}
