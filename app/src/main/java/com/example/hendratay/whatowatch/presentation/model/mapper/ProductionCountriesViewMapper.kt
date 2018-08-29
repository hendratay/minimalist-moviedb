package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.ProductionCountries
import com.example.hendratay.whatowatch.presentation.model.ProductionCountriesView
import javax.inject.Inject

class ProductionCountriesViewMapper @Inject constructor(): Mapper<ProductionCountriesView, ProductionCountries> {

    override fun mapToView(type: ProductionCountries): ProductionCountriesView {
        return ProductionCountriesView(type.iso, type.name)
    }

    fun mapToView(list: List<ProductionCountries>): List<ProductionCountriesView> {
        return list.map { mapToView(it) }
    }

}