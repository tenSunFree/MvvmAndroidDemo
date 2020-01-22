package com.home.mvvmandroiddemo.common.base

import androidx.databinding.ViewDataBinding
import com.home.mvvmandroiddemo.BR
import com.thefuntasty.mvvm.BaseViewModel
import com.thefuntasty.mvvm.ViewState
import com.thefuntasty.mvvm.dagger.fragment.bottomsheet.BaseDaggerBindingBottomSheetDialogFragment

abstract class BaseBottomSheetDialogFragment<VM : BaseViewModel<VS>, VS : ViewState, B : ViewDataBinding> :
    BaseDaggerBindingBottomSheetDialogFragment<VM, VS, B>() {

    override val brViewModelVariableId = BR.viewModel
    override val brViewStateVariableId = BR.viewState
    override val brViewVariableId = BR.view
}
