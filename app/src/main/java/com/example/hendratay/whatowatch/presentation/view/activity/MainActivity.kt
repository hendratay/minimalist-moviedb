package com.example.hendratay.whatowatch.presentation.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import com.example.hendratay.whatowatch.R
import com.example.hendratay.whatowatch.presentation.data.Resource
import com.example.hendratay.whatowatch.presentation.model.PopularMovieView
import com.example.hendratay.whatowatch.presentation.view.fragment.*
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularMovieViewModel
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularMovieViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var popularMovieViewModelFactory: PopularMovieViewModelFactory
    private lateinit var popularMovieViewModel: PopularMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawBehindStatusBar()
        setupBottomNavView()
        getPopularMovie()
    }

    override fun onBackPressed() {
        if(bottom_navigation_view.selectedItemId == R.id.action_home) finish()
        else bottom_navigation_view.selectedItemId = R.id.action_home
    }

    private fun drawBehindStatusBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }

    private fun setupBottomNavView() {
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.action_explore -> {
                    loadFragment(ExploreFragment())
                    true
                }
                R.id.action_movie -> {
                    loadFragment(MovieFragment())
                    true
                }
                R.id.action_tv -> {
                    loadFragment(TvFragment())
                    true
                }
                R.id.action_user -> {
                    loadFragment(UserFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment, fragment::class.simpleName)
                .addToBackStack(fragment::class.simpleName)
                .commit()
    }

    private fun getPopularMovie() {
        popularMovieViewModel = ViewModelProviders.of(this, popularMovieViewModelFactory)[PopularMovieViewModel::class.java]
        popularMovieViewModel.getPopularMovie().observe(this,
                Observer<Resource<PopularMovieView>> {
                    Log.d("data", it?.data.toString() )
                })
    }

}
