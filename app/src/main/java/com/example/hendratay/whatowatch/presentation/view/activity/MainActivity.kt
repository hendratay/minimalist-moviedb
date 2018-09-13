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
        loadFragment(AccountFragment())
        bottom_navigation_view.selectedItemId = R.id.action_account
    }

    override fun onBackPressed() {
        when(supportFragmentManager.findFragmentById(R.id.fragment_container)) {
            is AccountFragment -> finish()
            is MovieDetailFragment -> {
                bottom_navigation_view.visibility = View.VISIBLE
            }
            is TvDetailFragment -> {
                bottom_navigation_view.visibility = View.VISIBLE
                bottom_navigation_view.selectedItemId = R.id.action_tv
            }
            is ActorDetailFragment -> {
                bottom_navigation_view.visibility = View.VISIBLE
                bottom_navigation_view.selectedItemId = R.id.action_actor
            }
            else -> bottom_navigation_view.selectedItemId = R.id.action_account
        }
    }

    private fun drawBehindStatusBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }

    private fun setupBottomNavView() {
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_explore -> {
                    loadFragment(ExploreFragment())
                    true
                }
                R.id.action_movie -> {
                    loadFragment(MovieFragment())
                    true
                }
                R.id.action_account -> {
                    loadFragment(AccountFragment())
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
