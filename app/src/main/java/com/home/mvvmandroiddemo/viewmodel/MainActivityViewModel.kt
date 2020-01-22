package com.home.mvvmandroiddemo.viewmodel

import com.home.mvvmandroiddemo.common.rxusecases.BaseRxViewModel
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    override val viewState: MainActivityViewState
) : BaseRxViewModel<MainActivityViewState>()
