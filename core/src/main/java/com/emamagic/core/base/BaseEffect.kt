package com.emamagic.core.base

import android.view.View
import androidx.navigation.NavDirections
import com.emamagic.core.utils.AlertType
import com.emamagic.core.utils.ToastyMode

sealed interface BaseEffect {

    sealed class UIComponentType{

        object Toast: UIComponentType()

        object Dialog : UIComponentType()

        data class AreYouSureDialog(
            val callback: AreYouSureCallback
        ): UIComponentType()
        class SnackBar(
            val undoCallback: SnackbarUndoCallback? = null,
            val onDismissCallback: TodoCallback? = null
        ): UIComponentType()

        object None : UIComponentType()
    }

    sealed class MessageType{

        object Success : MessageType()

        object Error : MessageType()

        object Info: MessageType()

        object None: MessageType()
    }


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

interface StateMessageCallback{

    fun removeMessageFromStack()
}


interface AreYouSureCallback {

    fun proceed()

    fun cancel()
}

interface SnackbarUndoCallback {

    fun undo()
}
interface TodoCallback {

    fun execute()
}
class SnackbarUndoListener
constructor(
    private val snackbarUndoCallback: SnackbarUndoCallback?
): View.OnClickListener {

    override fun onClick(v: View?) {
        snackbarUndoCallback?.undo()
    }

}


interface DialogInputCaptureCallback {

    fun onTextCaptured(text: String)
}

/*-------------------------------------- CUSTOM EFFECT FOR EVERY FEATURE --------------------------------------*/

sealed class HomeEffect: BaseEffect {
    object StopShimmer: HomeEffect()
}
