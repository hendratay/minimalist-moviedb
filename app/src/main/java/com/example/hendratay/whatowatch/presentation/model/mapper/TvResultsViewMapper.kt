package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.TvResults
import com.example.hendratay.whatowatch.presentation.model.TvResultsView
import javax.inject.Inject

class TvResultsViewMapper @Inject constructor(): Mapper<TvResultsView, TvResults> {

    override fun mapToView(type: TvResults): TvResultsView {
        return TvResultsView(type.posterPath,
                type.popularity,
                type.id,
                type.backdropPath,
                type.voteAverage,
                type.mediaType,
                type.overview,
                type.firstAirDate,
                type.originCountry,
                type.genreIds,
                type.originalLanguage,
                type.voteCount,
                type.name,
                type.originalName)
    }

    fun mapToView(list: List<TvResults>?): List<TvResultsView>? {
        return list?.map { mapToView(it) }
    }

}
