package com.minimalist.moviedb.presentation.view.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.minimalist.moviedb.R
import com.minimalist.moviedb.presentation.view.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()
        setupBottomNavView()
        loadFragment(MovieTabFragment())
        bottom_navigation_view.selectedItemId = R.id.action_movie
    }

    override fun onBackPressed() {
        when(supportFragmentManager.findFragmentById(R.id.fragment_container)) {
            is AccountFragment -> finish()
            is MovieDetailFragment -> {
                bottom_navigation_view.visibility = View.VISIBLE
                bottom_navigation_view.selectedItemId = R.id.action_movie
            }
            is TvDetailFragment -> {
                bottom_navigation_view.visibility = View.VISIBLE
                bottom_navigation_view.selectedItemId = R.id.action_tv
            }
            is ActorDetailFragment -> {
                bottom_navigation_view.visibility = View.VISIBLE
                bottom_navigation_view.selectedItemId = R.id.action_actor
            }
            else -> bottom_navigation_view.selectedItemId = R.id.action_movie
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_account_circle_black_24dp)
    }

    private fun setupBottomNavView() {
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_explore -> {
                    loadFragment(ExploreFragment())
                    true
                }
                R.id.action_movie -> {
                    loadFragment(MovieTabFragment())
                    true
                }
                R.id.action_tv -> {
                    loadFragment(TvFragment())
                    true
                }
                R.id.action_actor -> {
                    loadFragment(ActorFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val newFragment: Fragment? = supportFragmentManager.findFragmentByTag(fragment::class.simpleName)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, newFragment ?: fragment, fragment::class.simpleName)
                .addToBackStack(fragment::class.simpleName)
                .commit()
    }

}
