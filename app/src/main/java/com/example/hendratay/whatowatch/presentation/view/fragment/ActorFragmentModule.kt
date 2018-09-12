package com.example.hendratay.whatowatch.presentation.view.fragment

import com.example.hendratay.whatowatch.domain.interactor.GetActorPopular
import com.example.hendratay.whatowatch.presentation.model.mapper.ActorPopularViewMapper
import com.example.hendratay.whatowatch.presentation.viewmodel.ActorPopularViewModelFactory
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
