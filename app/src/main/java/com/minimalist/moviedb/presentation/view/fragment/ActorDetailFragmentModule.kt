package com.minimalist.moviedb.presentation.view.fragment

import com.minimalist.moviedb.domain.interactor.GetActorDetail
import com.example.hendratay.whatowatch.presentation.model.mapper.ActorDetailViewMapper
import com.minimalist.moviedb.presentation.viewmodel.ActorDetailViewModelFactory
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
