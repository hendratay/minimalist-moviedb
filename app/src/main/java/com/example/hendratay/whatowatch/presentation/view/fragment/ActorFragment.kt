package com.example.hendratay.whatowatch.presentation.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hendratay.whatowatch.R
import com.example.hendratay.whatowatch.presentation.data.Resource
import com.example.hendratay.whatowatch.presentation.data.ResourceState
import com.example.hendratay.whatowatch.presentation.model.ActorPopularView
import com.example.hendratay.whatowatch.presentation.model.ActorResultsView
import com.example.hendratay.whatowatch.presentation.view.activity.MainActivity
import com.example.hendratay.whatowatch.presentation.view.adapter.ActorAdapter
import com.example.hendratay.whatowatch.presentation.viewmodel.ActorPopularViewModel
import com.example.hendratay.whatowatch.presentation.viewmodel.ActorPopularViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_actor.*
import javax.inject.Inject

class ActorFragment: Fragment() {

    @Inject lateinit var actorPopularViewModelFactory: ActorPopularViewModelFactory
    private lateinit var actorPopularViewModel: ActorPopularViewModel
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
        adapter = ActorAdapter(actorList) { getActorDetail(it) }
        rv_actor.layoutManager = GridLayoutManager(requireContext(), 3)
        rv_actor.adapter = adapter
        rv_actor.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if(dy > 0 && requireActivity().bottom_navigation_view.isShown) {
                    requireActivity().bottom_navigation_view?.visibility = View.GONE
                } else if(dy < 0) {
                    requireActivity().bottom_navigation_view.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun getPopularActor() {
        actorPopularViewModel = ViewModelProviders.of(this, actorPopularViewModelFactory)[ActorPopularViewModel::class.java]
        actorPopularViewModel.getActorPopular().observe(this,
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

    private fun getActorDetail(actorResultsView: ActorResultsView) {
        val args = Bundle()
        val actorDetailFragment = ActorDetailFragment()
        args.putInt("actor_id", actorResultsView.id)
        actorDetailFragment.arguments = args
        (activity as MainActivity).supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, actorDetailFragment)
                .addToBackStack(null)
                .commit()
    }

}