package com.home.mvvmandroiddemo.view

import android.os.Bundle
import com.home.mvvmandroiddemo.R
import com.home.mvvmandroiddemo.common.base.BaseActivity
import com.home.mvvmandroiddemo.databinding.ActivityMainBinding
import com.home.mvvmandroiddemo.viewmodel.MainActivityViewModel
import com.home.mvvmandroiddemo.viewmodel.MainActivityViewModelFactory
import com.home.mvvmandroiddemo.viewmodel.MainActivityViewState
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityViewModel, MainActivityViewState, ActivityMainBinding>(),
    MainActivityView {

    @Inject
    override lateinit var viewModelFactory: MainActivityViewModelFactory

    override val layoutResId = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView(savedInstanceState)
    }

    private fun initializeView(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout_root, MainFragment())
                .commit()
        }
    }
}
