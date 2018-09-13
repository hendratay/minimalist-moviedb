package com.example.hendratay.whatowatch.presentation.view.fragment

import com.example.hendratay.whatowatch.domain.interactor.GetActorDetail
import com.example.hendratay.whatowatch.presentation.model.mapper.ActorDetailViewMapper
import com.example.hendratay.whatowatch.presentation.viewmodel.ActorDetailViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ActorDetailFragmentModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideActorDetailViewModelFactory(getActorDetail: GetActorDetail,
                                               actorDetailViewMapper: ActorDetailViewMapper):
                ActorDetailViewModelFactory {
            return ActorDetailViewModelFactory(getActorDetail, actorDetailViewMapper)
        }
    }

}
