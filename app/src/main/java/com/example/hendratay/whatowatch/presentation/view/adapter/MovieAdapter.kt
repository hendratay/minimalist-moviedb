package com.example.hendratay.whatowatch.presentation.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hendratay.whatowatch.R
import com.example.hendratay.whatowatch.presentation.model.PopularMovieView
import com.example.hendratay.whatowatch.presentation.model.ResultsView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private val movieList: List<ResultsView>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(resultsView: ResultsView) {
            Picasso.get().load("http://image.tmdb.org/t/p/w780/${resultsView.backdropPath}").into(itemView.img_backdrop)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

}