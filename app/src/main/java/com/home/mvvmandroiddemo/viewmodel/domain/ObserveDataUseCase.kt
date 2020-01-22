package com.home.mvvmandroiddemo.viewmodel.domain

import com.home.mvvmandroiddemo.common.rxusecases.usecases.ObservableUseCase
import com.home.mvvmandroiddemo.model.data.model.DataModel
import com.home.mvvmandroiddemo.model.data.store.DataStore
import io.reactivex.Observable
import javax.inject.Inject

class ObserveDataUseCase @Inject constructor(
    private val userStore: DataStore
) : ObservableUseCase<Unit, List<DataModel>>() {

    override fun prepare(args: Unit): Observable<List<DataModel>> = userStore.getData()
}
