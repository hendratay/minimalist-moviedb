package com.minimalist.moviedb.presentation.view.fragment

import com.minimalist.moviedb.domain.interactor.GetTvDetail
import com.example.hendratay.whatowatch.presentation.model.mapper.TvDetailViewMapper
import com.minimalist.moviedb.presentation.viewmodel.TvDetailViewModelFactory
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
            return TvDetailViewModelFactory(getTvDetail, tvDetailViewMapper)
        }
    }

}
