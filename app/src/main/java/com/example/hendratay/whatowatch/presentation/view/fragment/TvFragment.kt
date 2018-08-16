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
import com.example.hendratay.whatowatch.presentation.model.PopularTvView
import com.example.hendratay.whatowatch.presentation.model.TvResultsView
import com.example.hendratay.whatowatch.presentation.view.adapter.TvAdapter
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularTvViewModel
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularTvViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_tv.*
import javax.inject.Inject

class TvFragment: Fragment() {

    @Inject lateinit var popularTvViewModelFactory: PopularTvViewModelFactory
    private lateinit var popularTvViewModel: PopularTvViewModel
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

    private fun setupRecyclerView() {
        rv_tv.layoutManager = LinearLayoutManager(requireContext())
        adapter = TvAdapter(tvList)
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
        popularTvViewModel = ViewModelProviders.of(this, popularTvViewModelFactory)[PopularTvViewModel::class.java]
        popularTvViewModel.getPopularMovie().observe(this,
                Observer<Resource<PopularTvView>> { it ->
                    it?.data?.let {
                        tvList.clear()
                        for (i in 0 until it.results.size) {
                            tvList.add(it.results[i])
                        }
                        adapter.notifyDataSetChanged()
                    }
                })
    }

}