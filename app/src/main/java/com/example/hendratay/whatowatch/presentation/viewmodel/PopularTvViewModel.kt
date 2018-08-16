package com.example.hendratay.whatowatch.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.util.Log
import com.example.hendratay.whatowatch.domain.interactor.DefaultObserver
import com.example.hendratay.whatowatch.domain.interactor.GetPopularTv
import com.example.hendratay.whatowatch.domain.model.PopularTv
import com.example.hendratay.whatowatch.presentation.data.Resource
import com.example.hendratay.whatowatch.presentation.data.ResourceState
import com.example.hendratay.whatowatch.presentation.model.PopularTvView
import com.example.hendratay.whatowatch.presentation.model.mapper.PopularTvViewMapper
import javax.inject.Inject

class PopularTvViewModel @Inject constructor(private val getPopularTv: GetPopularTv,
                                             private val popularTvViewMapper: PopularTvViewMapper):
        ViewModel() {

    private val popularTvLiveData: MutableLiveData<Resource<PopularTvView>> = MutableLiveData()

    init {
        fetchPopularTv()
    }

    override fun onCleared() {
        getPopularTv.dispose()
        super.onCleared()
    }

    fun getPopularMovie() = popularTvLiveData

    private fun fetchPopularTv() {
        popularTvLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        getPopularTv.execute(PopularMovieObserver(), GetPopularTv.Params.forPage(1))
    }

    inner class PopularMovieObserver: DefaultObserver<PopularTv>() {
        override fun onComplete() {
        }

        override fun onNext(t: PopularTv) {
            popularTvLiveData.postValue(Resource(ResourceState.SUCCESS, popularTvViewMapper.mapToView(t), null))
            Log.d("Tv Live Data", t.toString())
        }

        override fun onError(e: Throwable) {
            popularTvLiveData.postValue(Resource(ResourceState.ERROR, null, e.message))
            Log.d("Tv Live Data", e.toString())
        }
    }

}

open class PopularTvViewModelFactory(
        private val getPopularTv: GetPopularTv,
        private val popularTvViewMapper: PopularTvViewMapper): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PopularTvViewModel::class.java)) {
            return PopularTvViewModel(getPopularTv, popularTvViewMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
