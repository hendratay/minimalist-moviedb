package com.minimalist.moviedb.presentation.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minimalist.moviedb.R
import com.minimalist.moviedb.presentation.view.util.Genre
import kotlinx.android.synthetic.main.item_genre.view.*

class GenreAdapter(private val genres: IntArray): RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        return GenreViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_genre, parent, false))
    }

    override fun getItemCount(): Int {
        return genres.size
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bind(genres[position])
    }

    inner class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(genreId: Int) {
            itemView.txt_movie_genre.text = Genre.getGenre(genreId)
        }
    }
}