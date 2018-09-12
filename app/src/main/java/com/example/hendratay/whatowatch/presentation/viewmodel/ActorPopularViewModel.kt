package com.example.hendratay.whatowatch.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.util.Log
import com.example.hendratay.whatowatch.domain.interactor.DefaultObserver
import com.example.hendratay.whatowatch.domain.interactor.GetPopularActor
import com.example.hendratay.whatowatch.domain.model.ActorPopular
import com.example.hendratay.whatowatch.presentation.data.Resource
import com.example.hendratay.whatowatch.presentation.data.ResourceState
import com.example.hendratay.whatowatch.presentation.model.ActorPopularView
import com.example.hendratay.whatowatch.presentation.model.mapper.ActorPopularViewMapper
import javax.inject.Inject

class PopularActorViewModel @Inject constructor(private val getPopularActor: GetPopularActor,
                                                private val actorPopularViewMapper: ActorPopularViewMapper):
        ViewModel() {

    private val actorPopularLiveData: MutableLiveData<Resource<ActorPopularView>> = MutableLiveData()

    init {
        fetchPopularActor()
    }

    override fun onCleared() {
        getPopularActor.dispose()
        super.onCleared()
    }

    fun getPopularActor() = actorPopularLiveData

    private fun fetchPopularActor() {
        actorPopularLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        getPopularActor.execute(PopularActorObserver(), GetPopularActor.Params.forPage(1))
    }

    inner class PopularActorObserver: DefaultObserver<ActorPopular>() {
        override fun onComplete() {
        }

        override fun onNext(t: ActorPopular) {
            actorPopularLiveData.postValue(Resource(ResourceState.SUCCESS, actorPopularViewMapper.mapToView(t), null))
            Log.d("Popular Actor Success", t.toString())
        }

        override fun onError(e: Throwable) {
            actorPopularLiveData.postValue(Resource(ResourceState.ERROR, null, e.message))
            Log.d("Popular Actor Error", e.toString())
        }
    }

}

open class PopularActorViewModelFactory(
        private val getPopularActor: GetPopularActor,
        private val actorPopularViewMapper: ActorPopularViewMapper): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PopularActorViewModel::class.java)) {
            return PopularActorViewModel(getPopularActor, actorPopularViewMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
