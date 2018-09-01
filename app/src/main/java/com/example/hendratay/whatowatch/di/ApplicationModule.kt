package com.example.hendratay.whatowatch.di

import com.example.hendratay.whatowatch.data.entity.mapper.*
import com.example.hendratay.whatowatch.data.repository.ActorDataRepository
import com.example.hendratay.whatowatch.data.repository.MovieDataRepository
import com.example.hendratay.whatowatch.data.repository.TvDataRepository
import com.example.hendratay.whatowatch.data.repository.datasource.ActorDataStoreFactory
import com.example.hendratay.whatowatch.data.repository.datasource.MovieDataStoreFactory
import com.example.hendratay.whatowatch.data.repository.datasource.TvDataStoreFactory
import com.example.hendratay.whatowatch.domain.repository.ActorRepository
import com.example.hendratay.whatowatch.domain.repository.MovieRepository
import com.example.hendratay.whatowatch.domain.repository.TvRepository
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
                               actorPopularMapper: ActorPopularMapper): ActorRepository {
        return ActorDataRepository(actorDataStoreFactory, actorPopularMapper)
    }

}