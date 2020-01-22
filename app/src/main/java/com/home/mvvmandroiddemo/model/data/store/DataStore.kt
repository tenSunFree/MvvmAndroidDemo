package com.home.mvvmandroiddemo.model.data.store

import com.home.mvvmandroiddemo.model.data.model.DataModel
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStore @Inject constructor() {

    private val dataRelay = BehaviorRelay.createDefault(listOf<DataModel>())

    fun setData(data: List<DataModel>) {
        dataRelay.accept(data)
    }

    fun getData(): Observable<List<DataModel>> = dataRelay.hide()
}
