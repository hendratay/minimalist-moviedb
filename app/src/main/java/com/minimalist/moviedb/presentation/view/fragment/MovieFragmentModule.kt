package com.minimalist.moviedb.presentation.view.fragment

import com.minimalist.moviedb.domain.interactor.GetMoviePopular
import com.minimalist.moviedb.presentation.model.mapper.MoviePopularViewMapper
import com.minimalist.moviedb.presentation.viewmodel.MoviePopularViewModelFactory
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
