package com.example.hendratay.whatowatch.presentation.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hendratay.whatowatch.R
import com.example.hendratay.whatowatch.presentation.data.Resource
import com.example.hendratay.whatowatch.presentation.model.PopularMovieView
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularMovieViewModel
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularMovieViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var popularMovieViewModelFactory: PopularMovieViewModelFactory
    private lateinit var popularMovieViewModel: PopularMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        popularMovieViewModel = ViewModelProviders.of(this, popularMovieViewModelFactory)[PopularMovieViewModel::class.java]
        popularMovieViewModel.getPopularMovie().observe(this,
                Observer<Resource<PopularMovieView>> {
                    Log.d("data", it?.data.toString() )
                })
    }

}
