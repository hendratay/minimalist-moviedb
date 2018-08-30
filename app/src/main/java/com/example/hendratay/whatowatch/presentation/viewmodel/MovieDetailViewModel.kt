package com.example.hendratay.whatowatch.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.util.Log
import com.example.hendratay.whatowatch.domain.interactor.DefaultObserver
import com.example.hendratay.whatowatch.domain.interactor.GetMovieDetail
import com.example.hendratay.whatowatch.domain.model.MovieDetail
import com.example.hendratay.whatowatch.presentation.data.Resource
import com.example.hendratay.whatowatch.presentation.data.ResourceState
import com.example.hendratay.whatowatch.presentation.model.MovieDetailView
import com.example.hendratay.whatowatch.presentation.model.mapper.MovieDetailViewMapper
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val getMovieDetail: GetMovieDetail,
                                               private val movieDetailViewMapper: MovieDetailViewMapper):
        ViewModel() {

    private val movieDetailLiveData: MutableLiveData<Resource<MovieDetailView>> = MutableLiveData()
    private var movieId: Int = 0

    override fun onCleared() {
        getMovieDetail.dispose()
        super.onCleared()
    }

    fun getMovieDetail() = movieDetailLiveData

    fun setMovieId(movieId: Int) {
        this.movieId = movieId
        fetchMovieDetail()
    }

    private fun fetchMovieDetail() {
        movieDetailLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        getMovieDetail.execute(MovieDetailObserver(), GetMovieDetail.Params.forMovie(movieId))
    }

    inner class MovieDetailObserver: DefaultObserver<MovieDetail>() {
        override fun onComplete() {
        }

        override fun onNext(t: MovieDetail) {
            movieDetailLiveData.postValue(Resource(ResourceState.SUCCESS, movieDetailViewMapper.mapToView(t), null))
            Log.d("Popular Movie Success", t.toString())
        }

        override fun onError(e: Throwable) {
            movieDetailLiveData.postValue(Resource(ResourceState.ERROR, null, e.message))
            Log.d("Popular Movie Error", e.toString())
        }
    }

}

open class MovieDetailViewModelFactory(
        private val getMovieDetail: GetMovieDetail,
        private val movieDetailViewMapper: MovieDetailViewMapper): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieDetailViewModel::class.java)) {
            return MovieDetailViewModel(getMovieDetail, movieDetailViewMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
