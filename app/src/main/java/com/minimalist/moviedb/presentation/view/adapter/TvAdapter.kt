package com.minimalist.moviedb.presentation.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hendratay.whatowatch.R
import com.minimalist.moviedb.presentation.model.TvResultsView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_tv.view.*

class TvAdapter(private val tvList: List<TvResultsView>,
                private val clickListener: (TvResultsView) -> Unit): RecyclerView.Adapter<TvAdapter.TvViewHolder>() {

    inner class TvViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(tvResultsView: TvResultsView, clickListener: (TvResultsView) -> Unit) {
            Picasso.get().load("http://image.tmdb.org/t/p/w780/${tvResultsView.backdropPath}").into(itemView.img_tv_backdrop)
            itemView.setOnClickListener { clickListener(tvResultsView) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        return TvViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_tv, parent, false))
    }

    override fun getItemCount(): Int {
        return tvList.size
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        holder.bind(tvList[position], clickListener)
    }

}