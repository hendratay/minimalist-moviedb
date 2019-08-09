package com.minimalist.moviedb.di

import com.minimalist.moviedb.data.entity.mapper.*
import com.minimalist.moviedb.data.repository.ActorDataRepository
import com.minimalist.moviedb.data.repository.MovieDataRepository
import com.minimalist.moviedb.data.repository.TvDataRepository
import com.minimalist.moviedb.data.repository.datasource.ActorDataStoreFactory
import com.minimalist.moviedb.data.repository.datasource.MovieDataStoreFactory
import com.minimalist.moviedb.data.repository.datasource.TvDataStoreFactory
import com.minimalist.moviedb.domain.repository.ActorRepository
import com.minimalist.moviedb.domain.repository.MovieRepository
import com.minimalist.moviedb.domain.repository.TvRepository
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideMovieRepository(movieDataStoreFactory: MovieDataStoreFactory,
                               moviePopularMapper: MoviePopularMapper,
                               movieDetailMapper: MovieDetailMapper): MovieRepository {
        return MovieDataRepository(movieDataStoreFactory, moviePopularMapper, movieDetailMapper)
    }

    @Provides
    fun provideTvRepository(tvDataStoreFactory: TvDataStoreFactory,
                            tvPopularMapper: TvPopularMapper,
                            tvDetailMapper: TvDetailMapper): TvRepository {
        return TvDataRepository(tvDataStoreFactory, tvPopularMapper, tvDetailMapper)
    }

    @Provides
    fun provideActorRepository(actorDataStoreFactory: ActorDataStoreFactory,
                               actorPopularMapper: ActorPopularMapper,
                               actorDetailMapper: ActorDetailMapper): ActorRepository {
        return ActorDataRepository(actorDataStoreFactory, actorPopularMapper, actorDetailMapper)
    }

}