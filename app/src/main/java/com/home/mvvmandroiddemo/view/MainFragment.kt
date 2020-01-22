package com.home.mvvmandroiddemo.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.home.mvvmandroiddemo.R
import com.home.mvvmandroiddemo.common.base.BaseFragment
import com.home.mvvmandroiddemo.databinding.FragmentMain2Binding
import com.home.mvvmandroiddemo.viewmodel.*
import kotlinx.android.synthetic.main.fragment_main2.*
import javax.inject.Inject

class MainFragment : BaseFragment<MainFragmentViewModel, MainFragmentViewState, FragmentMain2Binding>(),
    MainFragmentView {

    @Inject override lateinit var viewModelFactory: MainFragmentViewModelFactory

    override val layoutResId = R.layout.fragment_main2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvent()
    }

    private fun observeEvent() {
        observeEvent(OnCompleteEvent::class) {
            recycler_view.apply {
                addItemDecoration(
                    SpacesItemDecoration(
                        resources.getDimension(
                            R.dimen.margin
                        ).toInt()
                    )
                )
                val adapter = MainAdapter()
                recycler_view.adapter = adapter
                adapter.submitList(it.data)
                adapter.setOnItemClickListener = {
                    Toast.makeText(context, "Click $it", Toast.LENGTH_LONG).show()
                }
            }
        }
        observeEvent(OnError::class) {
            Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
        }
    }
}
