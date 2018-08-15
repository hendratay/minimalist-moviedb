package com.example.hendratay.whatowatch.presentation.model.mapper

import com.example.hendratay.whatowatch.domain.model.MovieResults
import com.example.hendratay.whatowatch.presentation.model.ResultsView
import javax.inject.Inject

class ResultsViewMapper @Inject constructor(): Mapper<ResultsView, MovieResults> {

    override fun mapToView(type: MovieResults): ResultsView {
        return ResultsView(type.posterPath,
                type.adult,
                type.overview,
                type.releaseDate,
                type.genreIds,
                type.id,
                type.originalTitle,
                type.originalLanguage,
                type.title,
                type.backdropPath,
                type.popularity,
                type.voteCount,
                type.video,
                type.voteAverage)
    }

    fun mapToView(list: List<MovieResults>): List<ResultsView> {
        return list.map { mapToView(it) }
    }

}