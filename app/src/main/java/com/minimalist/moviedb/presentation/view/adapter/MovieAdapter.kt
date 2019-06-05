package com.minimalist.moviedb.presentation.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hendratay.whatowatch.R
import com.minimalist.moviedb.presentation.model.MovieResultsView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private val movieList: List<MovieResultsView>,
                   private val clickListener: (MovieResultsView) -> Unit): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(movieResultsView: MovieResultsView, clickListener: (MovieResultsView) -> Unit) {
            Picasso.get().load("http://image.tmdb.org/t/p/w780/${movieResultsView.backdropPath}").into(itemView.img_movie_backdrop)
            itemView.setOnClickListener { clickListener(movieResultsView) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position], clickListener)
    }

}