package com.minimalist.moviedb.presentation.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minimalist.moviedb.R
import com.minimalist.moviedb.presentation.data.Resource
import com.minimalist.moviedb.presentation.data.ResourceState
import com.minimalist.moviedb.presentation.model.MoviePopularView
import com.minimalist.moviedb.presentation.model.MovieResultsView
import com.minimalist.moviedb.presentation.view.activity.MainActivity
import com.minimalist.moviedb.presentation.view.adapter.MovieAdapter
import com.minimalist.moviedb.presentation.viewmodel.MoviePopularViewModel
import com.minimalist.moviedb.presentation.viewmodel.MoviePopularViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_movie.*
import javax.inject.Inject

class MovieFragment: Fragment() {

    @Inject lateinit var moviePopularViewModelFactory: MoviePopularViewModelFactory
    private lateinit var moviePopularViewModel: MoviePopularViewModel
    private lateinit var adapter: MovieAdapter
    private var movieList: MutableList<MovieResultsView> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        getPopularMovie()
    }

    override fun onPause() {
        super.onPause()
        requireActivity().bottom_navigation_view.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        rv_movie.layoutManager = LinearLayoutManager(requireContext())
        adapter = MovieAdapter(movieList) { getMovieDetail(it) }
        rv_movie.adapter = adapter
        rv_movie.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(dy > 0 && requireActivity().bottom_navigation_view.isShown) {
                    requireActivity().bottom_navigation_view?.visibility = View.GONE
                } else if(dy < 0) {
                    requireActivity().bottom_navigation_view.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun getPopularMovie() {
        moviePopularViewModel = ViewModelProviders.of(this, moviePopularViewModelFactory)[MoviePopularViewModel::class.java]
        moviePopularViewModel.getMoviePopular().observe(this,
                Observer<Resource<MoviePopularView>> { it ->
                    if(view?.parent != null) {
                        it?.let { handleMoviePopularViewState(it.status, it.data) }
                    }
                })
    }

    private fun handleMoviePopularViewState(resourceState: ResourceState, data: MoviePopularView?) {
        when(resourceState) {
            ResourceState.LOADING -> setupScreenForLoading()
            ResourceState.SUCCESS -> setupScreenForSuccess(data)
            ResourceState.ERROR -> setupScreenForError()
        }
    }

    private fun setupScreenForLoading() {
        rv_movie.visibility = View.GONE
        progress_bar_movie.visibility = View.VISIBLE
    }

    private fun setupScreenForSuccess(data: MoviePopularView?) {
        rv_movie.visibility = View.VISIBLE
        progress_bar_movie.visibility = View.GONE
        data?.results?.let {
            movieList.clear()
            for (i in 0 until it.size) {
                movieList.add(it[i])
            }
            adapter.notifyDataSetChanged()
        }
    }

    private fun setupScreenForError() {
        rv_movie.visibility = View.GONE
        progress_bar_movie.visibility = View.GONE
    }

    private fun getMovieDetail(movieResultsView: MovieResultsView) {
        val args = Bundle()
        val movieDetailFragment = MovieDetailFragment()
        args.putInt("movie_id", movieResultsView.id)
        movieDetailFragment.arguments = args
        (activity as MainActivity).supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, movieDetailFragment)
                .addToBackStack(null)
                .commit()
    }

}