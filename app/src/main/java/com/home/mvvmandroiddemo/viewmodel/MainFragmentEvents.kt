package com.home.mvvmandroiddemo.viewmodel

import com.home.mvvmandroiddemo.model.data.model.DataModel
import com.thefuntasty.mvvm.event.Event

sealed class MainFragmentEvents : Event<MainFragmentViewState>()

class OnCompleteEvent(val data: List<DataModel>) : MainFragmentEvents()

class OnError(val message: String) : MainFragmentEvents()
