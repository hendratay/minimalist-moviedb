package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.ProductionCountries
import com.minimalist.moviedb.presentation.model.ProductionCountriesView
import javax.inject.Inject

class ProductionCountriesViewMapper @Inject constructor(): Mapper<ProductionCountriesView, ProductionCountries> {

    override fun mapToView(type: ProductionCountries): ProductionCountriesView {
        return ProductionCountriesView(type.iso, type.name)
    }

    fun mapToView(list: List<ProductionCountries>): List<ProductionCountriesView> {
        return list.map { mapToView(it) }
    }

}