package com.emamagic.core.base

import androidx.navigation.NavDirections
import com.emamagic.core.utils.AlertType
import com.emamagic.core.utils.ToastyMode

sealed interface BaseEffect {

    data class ShowToast(
        val message: String,
        @ToastyMode val mode: Int = ToastyMode.MODE_TOAST_DEFAULT
    ) : BaseEffect

    data class ShowLoading(val isDim: Boolean = false) : BaseEffect

    object HideLoading : BaseEffect

    data class NavigateTo(val directions: NavDirections): BaseEffect

    object NavigateBack: BaseEffect

    data class ShowAlert(
        val message: String,
        val accept: String?,
        val decline: String?,
        @AlertType val alertType: Int,
        val canBeDismiss: Boolean = false,
//        val action: BaseFragment.DialogListener? = null
    ): BaseEffect

}

sealed class SigninEffect: BaseEffect {
    object CustomEffect: SigninEffect()
}
