package com.example.hendratay.whatowatch.presentation.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hendratay.whatowatch.R
import com.example.hendratay.whatowatch.presentation.data.Resource
import com.example.hendratay.whatowatch.presentation.model.PopularTvView
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularTvViewModel
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularTvViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class TvFragment: Fragment() {

    @Inject lateinit var popularTvViewModelFactory: PopularTvViewModelFactory
    private lateinit var popularTvViewModel: PopularTvViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        getPopularTv()
    }

    private fun getPopularTv() {
        popularTvViewModel = ViewModelProviders.of(this, popularTvViewModelFactory)[PopularTvViewModel::class.java]
        popularTvViewModel.getPopularMovie().observe(this,
                Observer<Resource<PopularTvView>> { it ->
                    it?.data?.let {
                    }
                })
    }

}