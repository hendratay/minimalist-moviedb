package com.example.hendratay.whatowatch.presentation.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.example.hendratay.whatowatch.R
import com.example.hendratay.whatowatch.presentation.data.Resource
import com.example.hendratay.whatowatch.presentation.model.MovieDetailView
import com.example.hendratay.whatowatch.presentation.viewmodel.MovieDetailViewModel
import com.example.hendratay.whatowatch.presentation.viewmodel.MovieDetailViewModelFactory
import com.squareup.picasso.Picasso
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import javax.inject.Inject

class MovieDetailFragment: Fragment() {

    @Inject lateinit var movieDetailViewModelFactory: MovieDetailViewModelFactory
    private lateinit var movieDetailViewModel: MovieDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
        requireActivity().bottom_navigation_view.visibility = View.GONE
    }

    override fun onResume() {
        super.onResume()
        getMovieDetail()
    }

    private fun getMovieDetail() {
        movieDetailViewModel = ViewModelProviders.of(this, movieDetailViewModelFactory)[MovieDetailViewModel::class.java]
        movieDetailViewModel.setMovieId(arguments?.getInt("movie_id") ?: 0)
        movieDetailViewModel.getMovieDetail().observe(this,
                Observer<Resource<MovieDetailView>> { it ->
                    it?.data?.let {
                        Picasso.get().load("http://image.tmdb.org/t/p/w780/${it.posterPath}").into(img_movie_detail_backdrop)
                    }
                })
    }

}