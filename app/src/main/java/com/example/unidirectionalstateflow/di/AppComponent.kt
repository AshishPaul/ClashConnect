package com.example.unidirectionalstateflow.di

import android.app.Application
import com.example.unidirectionalstateflow.AppController
import com.zerogravity.myapplication.di.DomainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        DataModule::class,
        DomainModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application : AppController)
}