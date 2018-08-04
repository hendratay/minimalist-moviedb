package com.example.hendratay.whatowatch.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.hendratay.whatowatch.domain.interactor.DefaultObserver
import com.example.hendratay.whatowatch.domain.interactor.GetPopularMovie
import com.example.hendratay.whatowatch.domain.model.PopularMovie
import com.example.hendratay.whatowatch.presentation.data.Resource
import com.example.hendratay.whatowatch.presentation.data.ResourceState
import com.example.hendratay.whatowatch.presentation.model.PopularMovieView
import com.example.hendratay.whatowatch.presentation.model.mapper.PopularMovieViewMapper

class PopularMovieViewModel(private val getPopularMovie: GetPopularMovie,
                            val popularMovieViewMapper: PopularMovieViewMapper): ViewModel() {

    private val popularMovieLiveData: MutableLiveData<Resource<PopularMovieView>> = MutableLiveData()

    override fun onCleared() {
        getPopularMovie.dispose()
        super.onCleared()
    }

    private fun getPopularMovie() = popularMovieLiveData

    private fun fetchPopularMovie() {
        popularMovieLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        getPopularMovie.execute(PopularMovieObserver(), GetPopularMovie.Params.forPage(1))
    }

    inner class PopularMovieObserver: DefaultObserver<PopularMovie>() {
        override fun onComplete() {
        }

        override fun onNext(t: PopularMovie) {
            popularMovieLiveData.postValue(Resource(ResourceState.SUCCESS, popularMovieViewMapper.mapToView(t), null))
            Log.d("Popular Movie", t.toString())
        }

        override fun onError(e: Throwable) {
            popularMovieLiveData.postValue(Resource(ResourceState.ERROR, null, e.message))
        }
    }

}