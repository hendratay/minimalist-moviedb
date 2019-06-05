package com.minimalist.moviedb.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.util.Log
import com.minimalist.moviedb.domain.interactor.DefaultObserver
import com.minimalist.moviedb.domain.interactor.GetActorDetail
import com.minimalist.moviedb.domain.model.ActorDetail
import com.minimalist.moviedb.presentation.data.Resource
import com.minimalist.moviedb.presentation.data.ResourceState
import com.minimalist.moviedb.presentation.model.ActorDetailView
import com.example.hendratay.whatowatch.presentation.model.mapper.ActorDetailViewMapper

class ActorDetailViewModel(private val getActorDetail: GetActorDetail,
                           private val actorDetailViewMapper: ActorDetailViewMapper):
        ViewModel() {

    private val actorDetailLiveData: MutableLiveData<Resource<ActorDetailView>> = MutableLiveData()
    private var actorId: Int = 0

    override fun onCleared() {
        getActorDetail.dispose()
        super.onCleared()
    }

    fun getActorDetail() = actorDetailLiveData

    fun setActorId(actorId: Int) {
        this.actorId = actorId
        fetchActorDetail()
    }

    private fun fetchActorDetail() {
        actorDetailLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        getActorDetail.execute(ActorDetailObserver(), GetActorDetail.Params.forActor(actorId))
    }

    inner class ActorDetailObserver: DefaultObserver<ActorDetail>() {
        override fun onComplete() {
        }

        override fun onNext(t: ActorDetail) {
            actorDetailLiveData.postValue(Resource(ResourceState.SUCCESS, actorDetailViewMapper.mapToView(t), null))
            Log.d("Actor Detail Success", t.toString())
        }

        override fun onError(e: Throwable) {
            actorDetailLiveData.postValue(Resource(ResourceState.ERROR, null, e.message))
            Log.d("Actor Detail Error", e.toString())
        }
    }

}

class ActorDetailViewModelFactory(
        private val getActorDetail: GetActorDetail,
        private val actorDetailViewMapper: ActorDetailViewMapper): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ActorDetailViewModel::class.java)) {
            return ActorDetailViewModel(getActorDetail, actorDetailViewMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
