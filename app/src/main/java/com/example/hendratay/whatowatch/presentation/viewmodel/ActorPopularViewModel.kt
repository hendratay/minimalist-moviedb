package com.example.hendratay.whatowatch.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.util.Log
import com.example.hendratay.whatowatch.domain.interactor.DefaultObserver
import com.example.hendratay.whatowatch.domain.interactor.GetActorPopular
import com.example.hendratay.whatowatch.domain.model.ActorPopular
import com.example.hendratay.whatowatch.presentation.data.Resource
import com.example.hendratay.whatowatch.presentation.data.ResourceState
import com.example.hendratay.whatowatch.presentation.model.ActorPopularView
import com.example.hendratay.whatowatch.presentation.model.mapper.ActorPopularViewMapper
import javax.inject.Inject

class ActorPopularViewModel @Inject constructor(private val getActorPopular: GetActorPopular,
                                                private val actorPopularViewMapper: ActorPopularViewMapper):
        ViewModel() {

    private val actorPopularLiveData: MutableLiveData<Resource<ActorPopularView>> = MutableLiveData()

    init {
        fetchActorPopular()
    }

    override fun onCleared() {
        getActorPopular.dispose()
        super.onCleared()
    }

    fun getActorPopular() = actorPopularLiveData

    private fun fetchActorPopular() {
        actorPopularLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        getActorPopular.execute(ActorPopularObserver(), GetActorPopular.Params.forPage(1))
    }

    inner class ActorPopularObserver: DefaultObserver<ActorPopular>() {
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

open class ActorPopularViewModelFactory(
        private val getActorPopular: GetActorPopular,
        private val actorPopularViewMapper: ActorPopularViewMapper): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ActorPopularViewModel::class.java)) {
            return ActorPopularViewModel(getActorPopular, actorPopularViewMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
