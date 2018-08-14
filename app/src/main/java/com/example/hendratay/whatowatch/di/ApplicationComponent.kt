package com.example.hendratay.whatowatch.di

import com.example.hendratay.whatowatch.Application
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityBuilder::class])
interface ApplicationComponent: AndroidInjector<Application> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<Application>()

}
