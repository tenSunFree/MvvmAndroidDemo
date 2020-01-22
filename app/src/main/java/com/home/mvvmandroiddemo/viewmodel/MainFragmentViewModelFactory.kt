package com.home.mvvmandroiddemo.viewmodel

import com.thefuntasty.mvvm.factory.BaseViewModelFactory
import javax.inject.Inject
import javax.inject.Provider

class MainFragmentViewModelFactory @Inject constructor(
    override val viewModelProvider: Provider<MainFragmentViewModel>
) : BaseViewModelFactory<MainFragmentViewModel>() {

    override val viewModelClass = MainFragmentViewModel::class
}
