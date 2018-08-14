package com.example.hendratay.whatowatch.presentation.view.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.hendratay.whatowatch.R
import com.example.hendratay.whatowatch.presentation.view.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawBehindStatusBar()
        setupBottomNavView()
        loadFragment(HomeFragment())
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
        val newFragment: Fragment? = supportFragmentManager.findFragmentByTag(fragment::class.simpleName)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, newFragment ?: fragment, fragment::class.simpleName)
                .addToBackStack(fragment::class.simpleName)
                .commit()
    }

}
