package com.minimalist.moviedb.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.util.Log
import com.minimalist.moviedb.domain.interactor.DefaultObserver
import com.minimalist.moviedb.domain.interactor.GetTvPopular
import com.minimalist.moviedb.domain.model.TvPopular
import com.minimalist.moviedb.presentation.data.Resource
import com.minimalist.moviedb.presentation.data.ResourceState
import com.minimalist.moviedb.presentation.model.TvPopularView
import com.example.hendratay.whatowatch.presentation.model.mapper.TvPopularViewMapper
import javax.inject.Inject

class TvPopularViewModel @Inject constructor(private val getTvPopular: GetTvPopular,
                                             private val tvPopularViewMapper: TvPopularViewMapper):
        ViewModel() {

    private val tvPopularLiveData: MutableLiveData<Resource<TvPopularView>> = MutableLiveData()

    init {
        fetchTvPopular()
    }

    override fun onCleared() {
        getTvPopular.dispose()
        super.onCleared()
    }

    fun getTvPopular() = tvPopularLiveData

    private fun fetchTvPopular() {
        tvPopularLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        getTvPopular.execute(TvPopularObserver(), GetTvPopular.Params.forPage(1))
    }

    inner class TvPopularObserver: DefaultObserver<TvPopular>() {
        override fun onComplete() {
        }

        override fun onNext(t: TvPopular) {
            tvPopularLiveData.postValue(Resource(ResourceState.SUCCESS, tvPopularViewMapper.mapToView(t), null))
            Log.d("Tv Live Data", t.toString())
        }

        override fun onError(e: Throwable) {
            tvPopularLiveData.postValue(Resource(ResourceState.ERROR, null, e.message))
            Log.d("Tv Live Data", e.toString())
        }
    }

}

open class TvPopularViewModelFactory(
        private val getTvPopular: GetTvPopular,
        private val tvPopularViewMapper: TvPopularViewMapper): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TvPopularViewModel::class.java)) {
            return TvPopularViewModel(getTvPopular, tvPopularViewMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
