package com.home.mvvmandroiddemo.viewmodel

import com.thefuntasty.mvvm.factory.BaseViewModelFactory
import javax.inject.Inject
import javax.inject.Provider

class MainActivityViewModelFactory @Inject constructor(
    override val viewModelProvider: Provider<MainActivityViewModel>
) : BaseViewModelFactory<MainActivityViewModel>() {

    override val viewModelClass = MainActivityViewModel::class
}
