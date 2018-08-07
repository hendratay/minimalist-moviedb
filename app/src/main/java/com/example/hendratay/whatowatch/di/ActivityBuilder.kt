package com.example.hendratay.whatowatch.di

import com.example.hendratay.whatowatch.presentation.view.activity.MainActivity
import com.example.hendratay.whatowatch.presentation.view.activity.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

}