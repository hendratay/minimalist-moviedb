package com.example.hendratay.whatowatch.presentation.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hendratay.whatowatch.R
import com.example.hendratay.whatowatch.presentation.data.Resource
import com.example.hendratay.whatowatch.presentation.data.ResourceState
import com.example.hendratay.whatowatch.presentation.model.ActorPopularView
import com.example.hendratay.whatowatch.presentation.model.ActorResultsView
import com.example.hendratay.whatowatch.presentation.view.adapter.ActorAdapter
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularActorViewModel
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularActorViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_actor.*
import javax.inject.Inject

class ActorFragment: Fragment() {

    @Inject lateinit var popularActorViewModelFactory: PopularActorViewModelFactory
    private lateinit var popularActorViewModel: PopularActorViewModel
    private lateinit var adapter: ActorAdapter
    private var actorList: MutableList<ActorResultsView> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_actor, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        getPopularActor()
    }

    private fun setupRecyclerView() {
        adapter = ActorAdapter(actorList)
        rv_actor.layoutManager = GridLayoutManager(requireContext(), 3)
        rv_actor.adapter = adapter

    }

    private fun getPopularActor() {
        popularActorViewModel = ViewModelProviders.of(this, popularActorViewModelFactory)[PopularActorViewModel::class.java]
        popularActorViewModel.getPopularActor().observe(this,
                Observer<Resource<ActorPopularView>> { it ->
                    if(view?.parent != null) {
                        it?.let { handleActorPopularViewState(it.status, it.data) }
                    }
                })
    }

    private fun handleActorPopularViewState(resourceState: ResourceState, data: ActorPopularView?) {
        when(resourceState) {
            ResourceState.LOADING -> setupScreenForLoading()
            ResourceState.SUCCESS -> setupScreenForSuccess(data)
            ResourceState.ERROR -> setupScreenForError()
        }
    }

    private fun setupScreenForLoading() {
        rv_actor.visibility = View.GONE
        progress_bar_actor.visibility = View.VISIBLE
    }

    private fun setupScreenForSuccess(data: ActorPopularView?) {
        rv_actor.visibility = View.VISIBLE
        progress_bar_actor.visibility = View.GONE
        data?.results?.let {
            actorList.clear()
            for (i in 0 until it.size) actorList.add(it[i])
            adapter.notifyDataSetChanged()
        }
    }

    private fun setupScreenForError() {
        rv_actor.visibility = View.GONE
        progress_bar_actor.visibility = View.GONE
    }

}