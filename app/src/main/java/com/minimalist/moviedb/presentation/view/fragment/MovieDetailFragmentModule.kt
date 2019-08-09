package com.minimalist.moviedb.presentation.view.fragment

import com.minimalist.moviedb.domain.interactor.GetMovieDetail
import com.minimalist.moviedb.presentation.model.mapper.MovieDetailViewMapper
import com.minimalist.moviedb.presentation.viewmodel.MovieDetailViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieDetailFragmentModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideMovieDetailViewModelFactory(getMovieDetail: GetMovieDetail,
                                               movieDetailViewMapper: MovieDetailViewMapper):
                MovieDetailViewModelFactory {
            return MovieDetailViewModelFactory(getMovieDetail, movieDetailViewMapper)
        }
    }

}
