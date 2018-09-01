package com.example.hendratay.whatowatch.presentation.view.fragment

import com.example.hendratay.whatowatch.domain.interactor.GetTvDetail
import com.example.hendratay.whatowatch.presentation.model.mapper.TvDetailViewMapper
import com.example.hendratay.whatowatch.presentation.viewmodel.TvDetailViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvDetailFragmentModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideTvDetailViewModelFactory(getTvDetail: GetTvDetail,
                                            tvDetailViewMapper: TvDetailViewMapper):
                TvDetailViewModelFactory {
            return TvDetailViewModelFactory(getTvDetail,tvDetailViewMapper)
        }
    }

}
