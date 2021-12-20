package com.emamagic.common_android.extension

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import com.emamagic.common_android.di.AppComponent
import com.emamagic.common_android.di.AppComponentProvider


fun Context.findBaseComponent(): AppComponent {
    return if (applicationContext is AppComponentProvider) {
        (applicationContext as AppComponentProvider).provideBaseComponent()
    } else {
        throw IllegalStateException("Provide the application context which implement BaseComponentProvider")
    }
}

fun View.findBaseComponent(): AppComponent = context.findBaseComponent()

fun Fragment.findBaseComponent(): AppComponent = requireContext().findBaseComponent()

