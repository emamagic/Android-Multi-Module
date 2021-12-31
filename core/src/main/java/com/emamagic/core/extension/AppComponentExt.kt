package com.emamagic.core.extension

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import com.emamagic.view_interactor.AppComponent
import com.emamagic.view_interactor.AppComponentProvider

fun Context.findAppComponent(): AppComponent {
    return if (applicationContext is AppComponentProvider) {
        (applicationContext as AppComponentProvider).provideAppComponent()
    } else {
        throw IllegalStateException("Provide the application context which implement BaseComponentProvider")
    }
}

fun View.findAppComponent(): AppComponent = context.findAppComponent()

fun Fragment.findAppComponent(): AppComponent = requireContext().findAppComponent()

