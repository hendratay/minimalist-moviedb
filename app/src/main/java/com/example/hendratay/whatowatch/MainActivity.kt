package com.example.hendratay.whatowatch

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hendratay.whatowatch.data.entity.mapper.PopularMovieMapper
import com.example.hendratay.whatowatch.data.entity.mapper.ResultsMapper
import com.example.hendratay.whatowatch.data.repository.MovieDataRepository
import com.example.hendratay.whatowatch.data.repository.datasource.MovieDataStoreFactory
import com.example.hendratay.whatowatch.domain.interactor.GetPopularMovie
import com.example.hendratay.whatowatch.presentation.data.Resource
import com.example.hendratay.whatowatch.presentation.model.PopularMovieView
import com.example.hendratay.whatowatch.presentation.model.mapper.PopularMovieViewMapper
import com.example.hendratay.whatowatch.presentation.model.mapper.ResultsViewMapper
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularMovieViewModel
import com.example.hendratay.whatowatch.presentation.viewmodel.PopularMovieViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var popularMovieViewModelFactory: PopularMovieViewModelFactory
    private lateinit var popularMovieViewModel: PopularMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        popularMovieViewModelFactory = PopularMovieViewModelFactory(GetPopularMovie(MovieDataRepository(MovieDataStoreFactory(), PopularMovieMapper(ResultsMapper()))), PopularMovieViewMapper(ResultsViewMapper()))
        popularMovieViewModel = ViewModelProviders.of(this, popularMovieViewModelFactory)[PopularMovieViewModel::class.java]
        popularMovieViewModel.getPopularMovie().observe(this,
                Observer<Resource<PopularMovieView>> {
                    Log.d("data", it?.data.toString() )
                })
    }

}
