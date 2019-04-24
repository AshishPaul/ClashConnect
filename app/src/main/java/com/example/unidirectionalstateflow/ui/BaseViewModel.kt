package com.example.unidirectionalstateflow.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

abstract class BaseViewModel<ViewState,ViewEffect,ViewEvent> : ViewModel() {


    abstract fun processInput(viewEvent: ViewEvent)
}
//
//fun <T :ViewModel> getViewModelForFragment(fragment: Fragment, viewModelFactory: ViewModelProvider.Factory) : T =
//    ViewModelProviders.of(fragment,viewModelFactory).get(T::class.java)