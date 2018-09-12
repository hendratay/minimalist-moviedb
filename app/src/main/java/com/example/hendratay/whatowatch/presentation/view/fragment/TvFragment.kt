package com.example.hendratay.whatowatch.presentation.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hendratay.whatowatch.R
import com.example.hendratay.whatowatch.presentation.data.Resource
import com.example.hendratay.whatowatch.presentation.data.ResourceState
import com.example.hendratay.whatowatch.presentation.model.TvPopularView
import com.example.hendratay.whatowatch.presentation.model.TvResultsView
import com.example.hendratay.whatowatch.presentation.view.activity.MainActivity
import com.example.hendratay.whatowatch.presentation.view.adapter.TvAdapter
import com.example.hendratay.whatowatch.presentation.viewmodel.TvPopularViewModel
import com.example.hendratay.whatowatch.presentation.viewmodel.TvPopularViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_tv.*
import javax.inject.Inject

class TvFragment: Fragment() {

    @Inject lateinit var tvPopularViewModelFactory: TvPopularViewModelFactory
    private lateinit var tvPopularViewModel: TvPopularViewModel
    private lateinit var adapter: TvAdapter
    private var tvList: MutableList<TvResultsView> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        getPopularTv()
    }

    override fun onPause() {
        super.onPause()
        requireActivity().bottom_navigation_view.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        rv_tv.layoutManager = LinearLayoutManager(requireContext())
        adapter = TvAdapter(tvList) { getTvDetail(it) }
        rv_tv.adapter = adapter
        rv_tv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if(dy > 0 && requireActivity().bottom_navigation_view.isShown) {
                    requireActivity().bottom_navigation_view?.visibility = View.GONE
                } else if(dy < 0) {
                    requireActivity().bottom_navigation_view.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun getPopularTv() {
        tvPopularViewModel = ViewModelProviders.of(this, tvPopularViewModelFactory)[TvPopularViewModel::class.java]
        tvPopularViewModel.getTvPopular().observe(this,
                Observer<Resource<TvPopularView>> { it ->
                    if(view?.parent != null) {
                        it?.let { handleTvPopularViewState(it.status, it.data) }
                    }
                })
    }

    private fun handleTvPopularViewState(resourceState: ResourceState, data: TvPopularView?) {
        when(resourceState) {
            ResourceState.LOADING -> setupScreenForLoading()
            ResourceState.SUCCESS -> setupScreenForSuccess(data)
            ResourceState.ERROR -> setupScreenForError()
        }
    }

    private fun setupScreenForLoading() {
        rv_tv.visibility = View.GONE
        progress_bar_tv.visibility = View.VISIBLE
    }

    private fun setupScreenForSuccess(data: TvPopularView?) {
        rv_tv.visibility = View.VISIBLE
        progress_bar_tv.visibility = View.GONE
        data?.results?.let {
            tvList.clear()
            for (i in 0 until it.size) tvList.add(it[i])
            adapter.notifyDataSetChanged()
        }
    }

    private fun setupScreenForError() {
        rv_tv.visibility = View.GONE
        progress_bar_tv.visibility = View.GONE
    }

    private fun getTvDetail(tvResultsView: TvResultsView) {
        val args = Bundle()
        val tvDetailFragment = TvDetailFragment()
        args.putInt("tv_id", tvResultsView.id)
        tvDetailFragment.arguments = args
        (activity as MainActivity).supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, tvDetailFragment)
                .addToBackStack(null)
                .commit()
    }

}