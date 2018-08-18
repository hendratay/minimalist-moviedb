package com.example.hendratay.whatowatch.presentation.view.fragment

import com.example.hendratay.whatowatch.domain.interactor.GetPopularMovie
import com.example.hendratay.whatowatch.presentation.model.mapper.MoviePopularViewMapper
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularMovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieFragmentModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun providePopularMovieViewModelFactory(getPopularMovie: GetPopularMovie,
                                                moviePopularViewMapper: MoviePopularViewMapper):
                PopularMovieViewModelFactory {
            return PopularMovieViewModelFactory(getPopularMovie, moviePopularViewMapper)
        }
    }

}
