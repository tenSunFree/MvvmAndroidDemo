package com.home.mvvmandroiddemo.common

import android.util.Log
import com.home.mvvmandroiddemo.common.injection.DaggerApplicationComponent
import com.home.mvvmandroiddemo.common.rxusecases.UseCaseErrorHandler
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        UseCaseErrorHandler.globalOnErrorLogger = { error ->
            Log.d("UseCase error", "$error")
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component = DaggerApplicationComponent.builder().application(this).build()
        component.inject(this)
        return component
    }
}
