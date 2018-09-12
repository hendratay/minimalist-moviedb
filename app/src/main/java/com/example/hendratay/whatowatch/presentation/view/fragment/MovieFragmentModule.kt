package com.example.hendratay.whatowatch.presentation.view.fragment

import com.example.hendratay.whatowatch.domain.interactor.GetMoviePopular
import com.example.hendratay.whatowatch.presentation.model.mapper.MoviePopularViewMapper
import com.example.hendratay.whatowatch.presentation.viewmodel.MoviePopularViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieFragmentModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideMoviePopularViewModelFactory(getMoviePopular: GetMoviePopular,
                                                moviePopularViewMapper: MoviePopularViewMapper):
                MoviePopularViewModelFactory {
            return MoviePopularViewModelFactory(getMoviePopular, moviePopularViewMapper)
        }
    }

}
