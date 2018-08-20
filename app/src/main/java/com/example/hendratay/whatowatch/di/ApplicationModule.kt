package com.example.hendratay.whatowatch.di

import com.example.hendratay.whatowatch.data.entity.mapper.ActorPopularMapper
import com.example.hendratay.whatowatch.data.entity.mapper.MoviePopularMapper
import com.example.hendratay.whatowatch.data.entity.mapper.TvPopularMapper
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
                               moviePopularMapper: MoviePopularMapper): MovieRepository {
        return MovieDataRepository(movieDataStoreFactory, moviePopularMapper)
    }

    @Provides
    fun provideTvRepository(tvDataStoreFactory: TvDataStoreFactory,
                            tvPopularMapper: TvPopularMapper): TvRepository {
        return TvDataRepository(tvDataStoreFactory, tvPopularMapper)
    }

    @Provides
    fun provideActorRepository(actorDataStoreFactory: ActorDataStoreFactory,
                               actorPopularMapper: ActorPopularMapper): ActorRepository {
        return ActorDataRepository(actorDataStoreFactory, actorPopularMapper)
    }

}