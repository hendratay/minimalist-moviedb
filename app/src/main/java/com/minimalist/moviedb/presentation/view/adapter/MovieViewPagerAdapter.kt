package com.minimalist.moviedb.presentation.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.minimalist.moviedb.presentation.view.fragment.MovieFragment

class MovieViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MovieFragment()
            1 -> MovieFragment()
            2 -> MovieFragment()
            else -> MovieFragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Popular"
            1 -> "Top Rated"
            2 -> "Upcoming"
            else -> "Now Playing"
        }
    }
}