package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.ProductionCompanies
import com.example.hendratay.whatowatch.presentation.model.ProductionCompaniesView
import javax.inject.Inject

class ProductionCompaniesViewMapper @Inject constructor(): Mapper<ProductionCompaniesView, ProductionCompanies> {

    override fun mapToView(type: ProductionCompanies): ProductionCompaniesView {
        return ProductionCompaniesView(type.name, type.id, type.logoPath, type.originCountry)
    }

    fun mapToView(list: List<ProductionCompanies>): List<ProductionCompaniesView> {
        return list.map { mapToView(it) }
    }

}