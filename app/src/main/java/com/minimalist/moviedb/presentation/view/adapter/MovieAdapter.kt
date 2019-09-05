package com.minimalist.moviedb.presentation.view.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minimalist.moviedb.R
import com.minimalist.moviedb.presentation.model.MovieResultsView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*
import java.text.SimpleDateFormat
import java.util.*

class MovieAdapter(private val movieList: List<MovieResultsView>,
                   private val clickListener: (MovieResultsView) -> Unit): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(position, movieList[position], clickListener)
    }

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int, movieResultsView: MovieResultsView, clickListener: (MovieResultsView) -> Unit) {
            Picasso.get().load("https://image.tmdb.org/t/p/w300/${movieResultsView.posterPath}").into(itemView.img_movie_backdrop)
            itemView.txt_movie_ranking.text = (position + 1).toString()
            itemView.txt_movie_title.text = movieResultsView.title
            val date = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(movieResultsView.releaseDate)
            val sdf = SimpleDateFormat("d MMMM YYYY", Locale.US)
            itemView.txt_movie_release_date.text = sdf.format(date)
            itemView.rating_movie_vote.rating = movieResultsView.voteAverage.toFloat() / 2
            itemView.txt_movie_vote.text = movieResultsView.voteAverage.toString()
            itemView.list_movie_genre.layoutManager = LinearLayoutManager(itemView.list_movie_genre.context, LinearLayoutManager.HORIZONTAL, false)
            itemView.list_movie_genre.adapter = GenreAdapter(movieResultsView.genreIds)
            itemView.setOnClickListener { clickListener(movieResultsView) }
        }
    }

}