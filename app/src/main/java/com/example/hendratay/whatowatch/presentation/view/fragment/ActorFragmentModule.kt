package com.example.hendratay.whatowatch.presentation.view.fragment

import com.example.hendratay.whatowatch.domain.interactor.GetPopularActor
import com.example.hendratay.whatowatch.presentation.model.mapper.ActorPopularViewMapper
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularActorViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ActorFragmentModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun providePopularActorViewModelFactory(getPopularActor: GetPopularActor,
                                                actorPopularViewMapper: ActorPopularViewMapper):
                PopularActorViewModelFactory {
            return PopularActorViewModelFactory(getPopularActor, actorPopularViewMapper)
        }
    }

}
