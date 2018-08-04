package com.example.hendratay.whatowatch.presentation.model.mapper

interface Mapper<V, D> {

    fun mapToView(type: D): V

}
