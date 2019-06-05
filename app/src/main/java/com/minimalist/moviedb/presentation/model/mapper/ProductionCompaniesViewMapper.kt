package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.ProductionCompanies
import com.minimalist.moviedb.presentation.model.ProductionCompaniesView
import javax.inject.Inject

class ProductionCompaniesViewMapper @Inject constructor(): Mapper<ProductionCompaniesView, ProductionCompanies> {

    override fun mapToView(type: ProductionCompanies): ProductionCompaniesView {
        return ProductionCompaniesView(type.name, type.id, type.logoPath, type.originCountry)
    }

    fun mapToView(list: List<ProductionCompanies>): List<ProductionCompaniesView> {
        return list.map { mapToView(it) }
    }

}