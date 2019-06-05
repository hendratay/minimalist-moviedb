package com.minimalist.moviedb.data.entity.mapper

import com.minimalist.moviedb.data.entity.ProductionCompaniesEntity
import com.minimalist.moviedb.domain.model.ProductionCompanies
import javax.inject.Inject

class ProductionCompaniesMapper @Inject constructor(): Mapper<ProductionCompaniesEntity, ProductionCompanies> {

    override fun mapFromEntity(type: ProductionCompaniesEntity): ProductionCompanies {
        return ProductionCompanies(type.name, type.id, type.logoPath, type.originCountry)
    }

    override fun mapToEntity(type: ProductionCompanies): ProductionCompaniesEntity {
        return ProductionCompaniesEntity(type.name, type.id, type.logoPath, type.originCountry)
    }

    fun mapFromEntity(list: List<ProductionCompaniesEntity>): List<ProductionCompanies> {
        return list.map { mapFromEntity(it) }
    }

    fun mapToEntity(list: List<ProductionCompanies>): List<ProductionCompaniesEntity> {
        return list.map { mapToEntity(it) }
    }

}