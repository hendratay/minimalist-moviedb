package com.minimalist.moviedb.presentation.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import com.minimalist.moviedb.R
import com.minimalist.moviedb.presentation.data.Resource
import com.minimalist.moviedb.presentation.model.MovieDetailView
import com.minimalist.moviedb.presentation.view.adapter.GenreAdapter
import com.minimalist.moviedb.presentation.viewmodel.MovieDetailViewModel
import com.minimalist.moviedb.presentation.viewmodel.MovieDetailViewModelFactory
import com.squareup.picasso.Picasso
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MovieDetailFragment: Fragment() {

    @Inject lateinit var movieDetailViewModelFactory: MovieDetailViewModelFactory
    private lateinit var movieDetailViewModel: MovieDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
        requireActivity().toolbar.visibility = View.GONE
        requireActivity().bottom_navigation_view.visibility = View.GONE
        drawBehindStatusBar()

    }

    override fun onResume() {
        super.onResume()
        getMovieDetail()
    }

    private fun drawBehindStatusBar() {
        requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        requireActivity().window.statusBarColor = Color.TRANSPARENT
    }

    private fun getMovieDetail() {
        movieDetailViewModel = ViewModelProviders.of(this, movieDetailViewModelFactory)[MovieDetailViewModel::class.java]
        movieDetailViewModel.setMovieId(arguments?.getInt("movie_id") ?: 0)
        movieDetailViewModel.getMovieDetail().observe(this,
                Observer<Resource<MovieDetailView>> { it ->
                    it?.data?.let { movieDetail ->
                        // TODO: budget and revenue use long, runtime null
                        Picasso.get().load("https://image.tmdb.org/t/p/original/${movieDetail.backdropPath}").fit().into(img_movie_media)
                        Picasso.get().load("https://image.tmdb.org/t/p/w300/${movieDetail.posterPath}").into(img_movie_poster)
                        text_movie_title.text = movieDetail.title
                        val date = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(movieDetail.releaseDate)
                        val sdf = SimpleDateFormat("d MMMM YYYY", Locale.US)
                        text_movie_release_date.text = sdf.format(date)
                        text_movie_runtime.text = getString(R.string.movie_runtime, movieDetail.runtime)
                        text_movie_budget.text = getString(R.string.movie_budget, movieDetail.budget / 1000000)
                        text_movie_revenue.text = getString(R.string.movie_revenue, movieDetail.revenue / 1000000)
                        text_movie_overview.text = movieDetail.overview
                        list_movie_genre.layoutManager = LinearLayoutManager(list_movie_genre.context, LinearLayoutManager.HORIZONTAL, false)
                        val genreId = arrayListOf<Int>()
                        for (genre in movieDetail.genres) { genreId.add(genre.id) }
                        list_movie_genre.adapter = GenreAdapter(genreId.toIntArray())
                    }
                })
    }

}