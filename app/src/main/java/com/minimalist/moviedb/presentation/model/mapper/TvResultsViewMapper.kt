package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.TvResults
import com.minimalist.moviedb.presentation.model.TvResultsView
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
