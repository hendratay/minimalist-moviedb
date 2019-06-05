package com.minimalist.moviedb.presentation.model.mapper

import com.minimalist.moviedb.domain.model.MovieResults
import com.minimalist.moviedb.presentation.model.MovieResultsView
import javax.inject.Inject

class MovieResultsViewMapper @Inject constructor(): Mapper<MovieResultsView, MovieResults> {

    override fun mapToView(type: MovieResults): MovieResultsView {
        return MovieResultsView(type.posterPath,
                type.adult,
                type.overview,
                type.releaseDate,
                type.genreIds,
                type.id,
                type.mediaType,
                type.originalTitle,
                type.originalLanguage,
                type.title,
                type.backdropPath,
                type.popularity,
                type.voteCount,
                type.video,
                type.voteAverage)
    }

    fun mapToView(list: List<MovieResults>?): List<MovieResultsView>? {
        return list?.map { mapToView(it) }
    }

}