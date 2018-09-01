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
import com.example.hendratay.whatowatch.presentation.model.TvDetailView
import com.example.hendratay.whatowatch.presentation.viewmodel.TvDetailViewModel
import com.example.hendratay.whatowatch.presentation.viewmodel.TvDetailViewModelFactory
import com.squareup.picasso.Picasso
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_tv_detail.*
import javax.inject.Inject

class TvDetailFragment: Fragment() {

    @Inject lateinit var tvDetailViewModelFactory: TvDetailViewModelFactory
    private lateinit var tvDetailViewModel: TvDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tv_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
        requireActivity().bottom_navigation_view.visibility = View.GONE
    }

    override fun onResume() {
        super.onResume()
        getTvDetail()
    }

    private fun getTvDetail() {
        tvDetailViewModel = ViewModelProviders.of(this, tvDetailViewModelFactory)[TvDetailViewModel::class.java]
        tvDetailViewModel.setTvId(arguments?.getInt("tv_id") ?: 0)
        tvDetailViewModel.getTvDetail().observe(this,
                Observer<Resource<TvDetailView>> { it ->
                    it?.data?.let {
                        Picasso.get().load("http://image.tmdb.org/t/p/w780/${it.posterPath}").into(img_tv_detail_backdrop)
                    }
                })
    }

}