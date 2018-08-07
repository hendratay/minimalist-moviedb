package com.example.hendratay.whatowatch.presentation.view.activity

import com.example.hendratay.whatowatch.domain.interactor.GetPopularMovie
import com.example.hendratay.whatowatch.presentation.model.mapper.PopularMovieViewMapper
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularMovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun providePopularMovieViewModelFactory(getPopularMovie: GetPopularMovie,
                                                popularMovieViewMapper: PopularMovieViewMapper):
                PopularMovieViewModelFactory {
            return PopularMovieViewModelFactory(getPopularMovie, popularMovieViewMapper)
        }
    }

}