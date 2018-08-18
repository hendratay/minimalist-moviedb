package com.example.hendratay.whatowatch.presentation.view.fragment

import com.example.hendratay.whatowatch.domain.interactor.GetPopularTv
import com.example.hendratay.whatowatch.presentation.model.mapper.TvPopularViewMapper
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularTvViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvFragmentModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun providePopularTvViewModelFactory(getPopularTv: GetPopularTv,
                                             tvPopularViewMapper: TvPopularViewMapper):
                PopularTvViewModelFactory {
            return PopularTvViewModelFactory(getPopularTv, tvPopularViewMapper)
        }
    }

}