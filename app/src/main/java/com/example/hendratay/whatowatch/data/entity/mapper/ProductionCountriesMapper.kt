package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.ProductionCountriesEntity
import com.example.hendratay.whatowatch.domain.model.ProductionCountries
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