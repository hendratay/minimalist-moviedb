package com.minimalist.moviedb.presentation.view.activity

import android.graphics.Color
import android.os.Build
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
        setupSystemUIVisibility()
        loadFragment(MovieTabFragment())
    }

    override fun onBackPressed() {
        when(supportFragmentManager.findFragmentById(R.id.fragment_container)) {
            is AccountFragment -> finish()
            is MovieDetailFragment -> {
                bottom_navigation_view.selectedItemId = R.id.action_movie
            }
            is TvDetailFragment -> {
                bottom_navigation_view.selectedItemId = R.id.action_tv
            }
            is ActorDetailFragment -> {
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

    fun setupSystemUIVisibility() {
        when(supportFragmentManager.findFragmentById(R.id.fragment_container)) {
            is MovieTabFragment -> {
                toolbar.visibility = View.VISIBLE
                bottom_navigation_view.visibility = View.VISIBLE
                window.decorView.systemUiVisibility = 0
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
                window.statusBarColor = Color.BLACK
            }
            is MovieDetailFragment -> {
                toolbar.visibility = View.GONE
                bottom_navigation_view.visibility = View.GONE
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                window.statusBarColor = Color.TRANSPARENT
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
