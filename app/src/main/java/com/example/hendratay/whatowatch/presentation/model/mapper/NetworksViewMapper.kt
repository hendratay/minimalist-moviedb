package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.Networks
import com.example.hendratay.whatowatch.presentation.model.NetworksView
import javax.inject.Inject

class NetworksViewMapper @Inject constructor(): Mapper<NetworksView, Networks> {

    override fun mapToView(type: Networks): NetworksView {
        return NetworksView(type.name, type.id, type.logoPath, type.originCountry)
    }

    fun mapToView(list: List<Networks>): List<NetworksView> {
        return list.map { mapToView(it) }
    }

}
