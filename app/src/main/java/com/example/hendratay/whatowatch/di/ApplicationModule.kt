package com.example.hendratay.whatowatch.di

import com.example.hendratay.whatowatch.data.entity.mapper.PopularMovieMapper
import com.example.hendratay.whatowatch.data.entity.mapper.PopularTvMapper
import com.example.hendratay.whatowatch.data.repository.MovieDataRepository
import com.example.hendratay.whatowatch.data.repository.TvDataRepository
import com.example.hendratay.whatowatch.data.repository.datasource.MovieDataStoreFactory
import com.example.hendratay.whatowatch.data.repository.datasource.TvDataStoreFactory
import com.example.hendratay.whatowatch.domain.repository.MovieRepository
import com.example.hendratay.whatowatch.domain.repository.TvRepository
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideMovieRepository(movieDataStoreFactory: MovieDataStoreFactory,
                               popularMovieMapper: PopularMovieMapper): MovieRepository {
        return MovieDataRepository(movieDataStoreFactory, popularMovieMapper)
    }

    @Provides
    fun provideTvRepository(tvDataStoreFactory: TvDataStoreFactory,
                            popularTvMapper: PopularTvMapper): TvRepository {
        return TvDataRepository(tvDataStoreFactory, popularTvMapper)
    }

}