package com.minimalist.moviedb.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.util.Log
import com.minimalist.moviedb.domain.interactor.DefaultObserver
import com.minimalist.moviedb.domain.interactor.GetTvDetail
import com.minimalist.moviedb.domain.model.TvDetail
import com.minimalist.moviedb.presentation.data.Resource
import com.minimalist.moviedb.presentation.data.ResourceState
import com.minimalist.moviedb.presentation.model.TvDetailView
import com.example.hendratay.whatowatch.presentation.model.mapper.TvDetailViewMapper
import javax.inject.Inject

class TvDetailViewModel @Inject constructor(private val getTvDetail: GetTvDetail,
                                            private val tvDetailViewMapper: TvDetailViewMapper):
        ViewModel() {

    private val tvDetailLiveData: MutableLiveData<Resource<TvDetailView>> = MutableLiveData()
    private var tvId: Int = 0

    override fun onCleared() {
        getTvDetail.dispose()
        super.onCleared()
    }

    fun getTvDetail() = tvDetailLiveData

    fun setTvId(tvId: Int) {
        this.tvId = tvId
        fetchTvDetail()
    }

    private fun fetchTvDetail() {
        tvDetailLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        getTvDetail.execute(TvDetailObserver(), GetTvDetail.Params.forTv(tvId))
    }

    inner class TvDetailObserver: DefaultObserver<TvDetail>() {
        override fun onComplete() {
        }

        override fun onNext(t: TvDetail) {
            tvDetailLiveData.postValue(Resource(ResourceState.SUCCESS, tvDetailViewMapper.mapToView(t), null))
            Log.d("Tv Detail Success", t.toString())
        }

        override fun onError(e: Throwable) {
            tvDetailLiveData.postValue(Resource(ResourceState.ERROR, null, e.message))
            Log.d("Tv Detail Error", e.toString())
        }
    }

}

open class TvDetailViewModelFactory(
        private val getTvDetail: GetTvDetail,
        private val tvDetailViewMapper: TvDetailViewMapper): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TvDetailViewModel::class.java)) {
            return TvDetailViewModel(getTvDetail, tvDetailViewMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
