package com.example.hendratay.whatowatch.di

import com.example.hendratay.whatowatch.presentation.view.fragment.MovieFragment
import com.example.hendratay.whatowatch.presentation.view.fragment.MovieFragmentModule
import com.example.hendratay.whatowatch.presentation.view.fragment.TvFragment
import com.example.hendratay.whatowatch.presentation.view.fragment.TvFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MovieFragmentModule::class])
    abstract fun bindMovieFragment(): MovieFragment

    @ContributesAndroidInjector(modules = [TvFragmentModule::class])
    abstract fun bindTvFragment(): TvFragment

}