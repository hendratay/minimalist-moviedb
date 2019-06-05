package com.minimalist.moviedb.di

import com.minimalist.moviedb.Application
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityBuilder::class])
interface ApplicationComponent: AndroidInjector<Application> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<Application>()

}
