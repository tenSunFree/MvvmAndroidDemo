package com.home.mvvmandroiddemo.viewmodel

import com.home.mvvmandroiddemo.model.data.model.DataModel
import com.thefuntasty.mvvm.ViewState
import com.thefuntasty.mvvm.livedata.DefaultValueLiveData
import javax.inject.Inject

class MainFragmentViewState @Inject constructor() : ViewState {

    val isLoading = DefaultValueLiveData(false)

    val data = DefaultValueLiveData(listOf<DataModel>())
}
