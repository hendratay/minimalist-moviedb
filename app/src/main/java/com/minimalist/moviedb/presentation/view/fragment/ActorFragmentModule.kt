package com.minimalist.moviedb.presentation.view.fragment

import com.minimalist.moviedb.domain.interactor.GetActorPopular
import com.example.hendratay.whatowatch.presentation.model.mapper.ActorPopularViewMapper
import com.minimalist.moviedb.presentation.viewmodel.ActorPopularViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ActorFragmentModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideActorPopularViewModelFactory(getActorPopular: GetActorPopular,
                                                actorPopularViewMapper: ActorPopularViewMapper):
                ActorPopularViewModelFactory {
            return ActorPopularViewModelFactory(getActorPopular, actorPopularViewMapper)
        }
    }

}
