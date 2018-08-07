package com.example.hendratay.whatowatch.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.util.Log
import com.example.hendratay.whatowatch.domain.interactor.DefaultObserver
import com.example.hendratay.whatowatch.domain.interactor.GetPopularMovie
import com.example.hendratay.whatowatch.domain.model.PopularMovie
import com.example.hendratay.whatowatch.presentation.data.Resource
import com.example.hendratay.whatowatch.presentation.data.ResourceState
import com.example.hendratay.whatowatch.presentation.model.PopularMovieView
import com.example.hendratay.whatowatch.presentation.model.mapper.PopularMovieViewMapper
import javax.inject.Inject

class PopularMovieViewModel @Inject constructor(private val getPopularMovie: GetPopularMovie,
                                                private val popularMovieViewMapper: PopularMovieViewMapper):
        ViewModel() {

    private val popularMovieLiveData: MutableLiveData<Resource<PopularMovieView>> = MutableLiveData()

    init {
        fetchPopularMovie()
    }

    override fun onCleared() {
        getPopularMovie.dispose()
        super.onCleared()
    }

    fun getPopularMovie() = popularMovieLiveData

    private fun fetchPopularMovie() {
        popularMovieLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        getPopularMovie.execute(PopularMovieObserver(), GetPopularMovie.Params.forPage(2))
    }

    inner class PopularMovieObserver: DefaultObserver<PopularMovie>() {
        override fun onComplete() {
        }

        override fun onNext(t: PopularMovie) {
            popularMovieLiveData.postValue(Resource(ResourceState.SUCCESS, popularMovieViewMapper.mapToView(t), null))
            Log.d("Popular Movie Success", t.toString())
        }

        override fun onError(e: Throwable) {
            popularMovieLiveData.postValue(Resource(ResourceState.ERROR, null, e.message))
            Log.d("Popular Movie Error", e.toString())
        }
    }

}

open class PopularMovieViewModelFactory(
        private val getPopularMovie: GetPopularMovie,
        private val popularMovieViewMapper: PopularMovieViewMapper): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PopularMovieViewModel::class.java)) {
            return PopularMovieViewModel(getPopularMovie, popularMovieViewMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}