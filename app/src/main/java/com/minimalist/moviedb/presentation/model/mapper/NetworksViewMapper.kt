package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.Networks
import com.minimalist.moviedb.presentation.model.NetworksView
import javax.inject.Inject

class NetworksViewMapper @Inject constructor(): Mapper<NetworksView, Networks> {

    override fun mapToView(type: Networks): NetworksView {
        return NetworksView(type.name, type.id, type.logoPath, type.originCountry)
    }

    fun mapToView(list: List<Networks>): List<NetworksView> {
        return list.map { mapToView(it) }
    }

}
