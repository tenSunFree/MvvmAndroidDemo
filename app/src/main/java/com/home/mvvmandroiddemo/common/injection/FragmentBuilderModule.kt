package com.home.mvvmandroiddemo.common.injection

import com.home.mvvmandroiddemo.view.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun loginFragment(): MainFragment
}
