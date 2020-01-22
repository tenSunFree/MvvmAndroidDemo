package com.home.mvvmandroiddemo.common.rxusecases

import androidx.lifecycle.LiveData
import com.home.mvvmandroiddemo.common.rxusecases.disposables.DisposablesOwner
import com.home.mvvmandroiddemo.common.rxusecases.usecases.ObservableUseCase
import com.thefuntasty.mvvm.BaseViewModel
import com.thefuntasty.mvvm.ViewState
import io.reactivex.disposables.CompositeDisposable

/**
 * Base ViewModel class prepared for providing data to UI through [LiveData] and
 * obtaining data from Stores (Repositories) by executing RxJava based use cases
 * eg. [ObservableUseCase].
 */
abstract class BaseRxViewModel<S : ViewState> : BaseViewModel<S>(), DisposablesOwner {

    /**
     * CompositeDisposable of all recently executed use cases which is cleared when
     * ViewModel is no longer used and will be destroyed.
     */
    override val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
