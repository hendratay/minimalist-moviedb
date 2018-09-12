package com.example.hendratay.whatowatch.presentation.view.fragment

import com.example.hendratay.whatowatch.domain.interactor.GetTvPopular
import com.example.hendratay.whatowatch.presentation.model.mapper.TvPopularViewMapper
import com.example.hendratay.whatowatch.presentation.viewmodel.TvPopularViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvFragmentModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideTvPopularViewModelFactory(getTvPopular: GetTvPopular,
                                             tvPopularViewMapper: TvPopularViewMapper):
                TvPopularViewModelFactory {
            return TvPopularViewModelFactory(getTvPopular, tvPopularViewMapper)
        }
    }

}