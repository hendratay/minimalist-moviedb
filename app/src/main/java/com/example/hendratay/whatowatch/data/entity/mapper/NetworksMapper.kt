package com.example.hendratay.whatowatch.data.entity.mapper

import com.example.hendratay.whatowatch.data.entity.NetworksEntity
import com.example.hendratay.whatowatch.domain.model.Networks
import javax.inject.Inject

class NetworksMapper @Inject constructor(): Mapper<NetworksEntity, Networks> {

    override fun mapFromEntity(type: NetworksEntity): Networks {
        return Networks(type.name, type.id, type.logoPath, type.originCountry)
    }

    override fun mapToEntity(type: Networks): NetworksEntity {
        return NetworksEntity(type.name, type.id, type.logoPath, type.originCountry)
    }

    fun mapFromEntity(list: List<NetworksEntity>): List<Networks> {
        return list.map { mapFromEntity(it) }
    }

    fun mapToEntity(list: List<Networks>): List<NetworksEntity> {
        return list.map { mapToEntity(it) }
    }

}
