package com.minimalist.moviedb.presentation.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hendratay.whatowatch.R
import com.minimalist.moviedb.presentation.data.Resource
import com.minimalist.moviedb.presentation.model.ActorDetailView
import com.minimalist.moviedb.presentation.viewmodel.ActorDetailViewModel
import com.minimalist.moviedb.presentation.viewmodel.ActorDetailViewModelFactory
import com.squareup.picasso.Picasso
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_actor_detail.*
import javax.inject.Inject

class ActorDetailFragment: Fragment() {

    @Inject lateinit var actorDetailViewModelFactory: ActorDetailViewModelFactory
    private lateinit var actorDetailViewModel: ActorDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_actor_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
        requireActivity().bottom_navigation_view.visibility = View.GONE
    }

    override fun onResume() {
        super.onResume()
        getActorDetail()
    }

    private fun getActorDetail() {
        actorDetailViewModel = ViewModelProviders.of(this, actorDetailViewModelFactory)[ActorDetailViewModel::class.java]
        actorDetailViewModel.setActorId(arguments?.getInt("actor_id") ?: 0)
        actorDetailViewModel.getActorDetail().observe(this,
                Observer<Resource<ActorDetailView>> { it ->
                    it?.data?.let {
                        Picasso.get().load("http://image.tmdb.org/t/p/w780/${it.profilePath}").into(img_actor_detail_profile)
                    }
                })
    }

}