package com.home.mvvmandroiddemo.viewmodel

import com.home.mvvmandroiddemo.common.rxusecases.BaseRxViewModel
import com.home.mvvmandroiddemo.viewmodel.domain.GetDataUseCase
import com.home.mvvmandroiddemo.viewmodel.domain.ObserveDataUseCase
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(
    private val getData: GetDataUseCase,
    private val observeData: ObserveDataUseCase,
    override val viewState: MainFragmentViewState
) : BaseRxViewModel<MainFragmentViewState>() {

    override fun onStart() {
        getData()
        observeData.execute(Unit) { onNext { viewState.data.value = it } }
    }

    private fun getData() = with(viewState) {
        getData.execute {
            onStart { isLoading.value = true }
            onComplete {
                isLoading.value = false
                sendEvent(OnCompleteEvent(viewState.data.value))
            }
            onError {
                isLoading.value = false
                sendEvent(OnError("Error!"))
            }
        }
    }
}
