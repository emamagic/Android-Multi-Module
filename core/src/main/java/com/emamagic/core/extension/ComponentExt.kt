package com.emamagic.core.extension

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment

inline fun <reified ComponentProvider> Context.findComponent(): ComponentProvider {
    return if (applicationContext is ComponentProvider) {
        (applicationContext as ComponentProvider)
    } else {
        throw IllegalStateException("Provide the application context which implement SubComponent")
    }
}

inline fun <reified ComponentProvider> View.findComponent(): ComponentProvider = context.findComponent()

inline fun <reified ComponentProvider> Fragment.findComponent(): ComponentProvider = requireContext().findComponent()

