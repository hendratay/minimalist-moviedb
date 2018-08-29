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
import com.example.hendratay.whatowatch.presentation.model.MovieDetailView
import com.example.hendratay.whatowatch.presentation.viewmodel.MovieDetailViewModel
import com.example.hendratay.whatowatch.presentation.viewmodel.MovieDetailViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MovieDetailFragment: Fragment() {

    @Inject
    lateinit var movieDetailViewModelFactory: MovieDetailViewModelFactory
    private lateinit var movieDetailViewModel: MovieDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        getMovieDetail()
    }

    private fun getMovieDetail() {
        movieDetailViewModel = ViewModelProviders.of(this, movieDetailViewModelFactory)[MovieDetailViewModel::class.java]
        movieDetailViewModel.getMovieDetail().observe(this,
                Observer<Resource<MovieDetailView>> { it ->
                })
    }

}