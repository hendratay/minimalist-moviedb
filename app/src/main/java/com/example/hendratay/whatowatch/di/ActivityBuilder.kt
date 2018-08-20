package com.example.hendratay.whatowatch.di

import com.example.hendratay.whatowatch.presentation.view.fragment.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MovieFragmentModule::class])
    abstract fun bindMovieFragment(): MovieFragment

    @ContributesAndroidInjector(modules = [TvFragmentModule::class])
    abstract fun bindTvFragment(): TvFragment

    @ContributesAndroidInjector(modules = [ActorFragmentModule::class])
    abstract fun bindActorFragment(): ActorFragment

}