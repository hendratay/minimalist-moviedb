package com.example.hendratay.whatowatch.presentation.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hendratay.whatowatch.R
import com.example.hendratay.whatowatch.presentation.model.ActorResultsView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_actor.view.*

class ActorAdapter(private val actorList: List<ActorResultsView>,
                   private val clickListener: (ActorResultsView) -> Unit): RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {

    inner class ActorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(actorResultsView: ActorResultsView, clickListener: (ActorResultsView) -> Unit) {
            Picasso.get().load("http://image.tmdb.org/t/p/w400/${actorResultsView.profilePath}").into(itemView.img_actor_profile)
            itemView.txt_actor_name.text = actorResultsView.name
            itemView.txt_actor_known_for.text = actorResultsView.knowForMovie?.get(0)?.title ?: actorResultsView.knownForTv?.get(0)?.name
            itemView.setOnClickListener { clickListener(actorResultsView) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_actor, parent, false))
    }

    override fun getItemCount(): Int {
        return actorList.size
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(actorList[position], clickListener)
    }

}