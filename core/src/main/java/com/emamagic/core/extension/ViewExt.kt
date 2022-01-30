package com.emamagic.core.extension

import android.content.Context
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.emamagic.core.interfaces.OnAppVisibility
import java.lang.ref.WeakReference

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

inline fun <T : View> T.afterMeasured(crossinline f: T.() -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (measuredWidth > 0 && measuredHeight > 0) {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
                f()
            }
        }
    })
}

fun isFragmentVisible(fragment: WeakReference<Fragment>): Boolean =
    (fragment.get() != null && fragment.get()!!.activity != null &&
            fragment.get()!!.isVisible && !fragment.get()!!.isRemoving)


fun Context.appIsInBackground(): Boolean {
    return if (applicationContext is OnAppVisibility) {
        (applicationContext as OnAppVisibility).appIsInBackground()
    } else {
        throw IllegalStateException("Provide the application context which implement App Visibility")
    }
}

fun View.appIsInBackground(): Boolean = context.appIsInBackground()

fun Fragment.appIsInBackground(): Boolean = requireContext().appIsInBackground()


