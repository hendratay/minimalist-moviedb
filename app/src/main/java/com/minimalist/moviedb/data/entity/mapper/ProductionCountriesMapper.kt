package com.minimalist.moviedb.data.entity.mapper

import com.minimalist.moviedb.data.entity.ProductionCountriesEntity
import com.minimalist.moviedb.domain.model.ProductionCountries
import javax.inject.Inject

class ProductionCountriesMapper @Inject constructor(): Mapper<ProductionCountriesEntity, ProductionCountries> {

    override fun mapFromEntity(type: ProductionCountriesEntity): ProductionCountries {
        return ProductionCountries(type.iso, type.name)
    }

    override fun mapToEntity(type: ProductionCountries): ProductionCountriesEntity {
        return ProductionCountriesEntity(type.iso, type.name)
    }

    fun mapFromEntity(list: List<ProductionCountriesEntity>): List<ProductionCountries> {
        return list.map { mapFromEntity(it) }
    }

    fun mapToEntity(list: List<ProductionCountries>): List<ProductionCountriesEntity> {
        return list.map { mapToEntity(it) }
    }

}