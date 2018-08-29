package com.example.hendratay.whatowatch.presentation.view.fragment

import com.example.hendratay.whatowatch.domain.interactor.GetMovieDetail
import com.example.hendratay.whatowatch.presentation.model.mapper.MovieDetailViewMapper
import com.example.hendratay.whatowatch.presentation.viewmodel.MovieDetailViewModelFactory
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
