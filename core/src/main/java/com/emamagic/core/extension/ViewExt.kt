package com.emamagic.core.extension

import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.emamagic.core.utils.Event
import com.google.android.material.snackbar.Snackbar

/**
 * Transforms static java function Snackbar.make() to an extension function on View.
 */
fun Fragment.showSnackBar(snackBarText: String, timeLength: Int) {
    activity?.let { Snackbar.make(it.findViewById(android.R.id.content), snackBarText, timeLength).show() }
}

/**
 * Triggers a snackbar message when the value contained by snackbarTaskMessageLiveEvent is modified.
 */
fun Fragment.setupSnackBar(lifecycleOwner: LifecycleOwner, snackBarEvent: LiveData<Event<Int>>, timeLength: Int) {
    snackBarEvent.observe(lifecycleOwner) { event ->
        event.getContentIfNotHandled()?.let { res ->
            context?.let { showSnackBar(it.getString(res), timeLength) }
        }
    }
}

fun View.gone() {
    if (isVisible)
        visibility = View.GONE
}

fun View.inVisible() {
    if (isVisible)
        visibility = View.INVISIBLE
}

fun View.visible() {
    if (!isVisible)
        visibility = View.VISIBLE
}