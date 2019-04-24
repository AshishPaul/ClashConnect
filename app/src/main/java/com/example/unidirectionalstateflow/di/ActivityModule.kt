package com.example.unidirectionalstateflow.di

import com.example.unidirectionalstateflow.ui.modules.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = arrayOf(FragmentBuildersModule::class))
    abstract fun contributesHomeActivity() : HomeActivity
}