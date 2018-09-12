package com.example.hendratay.whatowatch.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.util.Log
import com.example.hendratay.whatowatch.domain.interactor.DefaultObserver
import com.example.hendratay.whatowatch.domain.interactor.GetPopularMovie
import com.example.hendratay.whatowatch.domain.model.MoviePopular
import com.example.hendratay.whatowatch.presentation.data.Resource
import com.example.hendratay.whatowatch.presentation.data.ResourceState
import com.example.hendratay.whatowatch.presentation.model.MoviePopularView
import com.example.hendratay.whatowatch.presentation.model.mapper.MoviePopularViewMapper
import javax.inject.Inject

class PopularMovieViewModel @Inject constructor(private val getPopularMovie: GetPopularMovie,
                                                private val moviePopularViewMapper: MoviePopularViewMapper):
        ViewModel() {

    private val moviePopularLiveData: MutableLiveData<Resource<MoviePopularView>> = MutableLiveData()

    init {
        fetchPopularMovie()
    }

    override fun onCleared() {
        getPopularMovie.dispose()
        super.onCleared()
    }

    fun getPopularMovie() = moviePopularLiveData

    private fun fetchPopularMovie() {
        moviePopularLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        getPopularMovie.execute(PopularMovieObserver(), GetPopularMovie.Params.forPage(1))
    }

    inner class PopularMovieObserver: DefaultObserver<MoviePopular>() {
        override fun onComplete() {
        }

        override fun onNext(t: MoviePopular) {
            moviePopularLiveData.postValue(Resource(ResourceState.SUCCESS, moviePopularViewMapper.mapToView(t), null))
            Log.d("Popular Movie Success", t.toString())
        }

        override fun onError(e: Throwable) {
            moviePopularLiveData.postValue(Resource(ResourceState.ERROR, null, e.message))
            Log.d("Popular Movie Error", e.toString())
        }
    }

}

open class PopularMovieViewModelFactory(
        private val getPopularMovie: GetPopularMovie,
        private val moviePopularViewMapper: MoviePopularViewMapper): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PopularMovieViewModel::class.java)) {
            return PopularMovieViewModel(getPopularMovie, moviePopularViewMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}