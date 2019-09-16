package com.minimalist.moviedb.presentation.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minimalist.moviedb.R
import com.minimalist.moviedb.presentation.view.activity.MainActivity
import com.minimalist.moviedb.presentation.view.adapter.MovieViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_movie_tab.*

class MovieTabFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_tab, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupTab()
        (requireActivity() as MainActivity).setupSystemUIVisibility()
    }

    private fun setupTab() {
        if (activity != null) {
            view_pager_movie.adapter = MovieViewPagerAdapter(childFragmentManager)
            tab_movie.setupWithViewPager(view_pager_movie)
        }
    }
}