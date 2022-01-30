package com.emamagic.android_multi_module

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.multidex.MultiDexApplication
import com.emamagic.android_multi_module.di.AppComponentProvider
import com.emamagic.android_multi_module.di.SubComponents
import com.emamagic.core.interfaces.OnAppVisibility

class App: MultiDexApplication(), SubComponents, LifecycleEventObserver, OnAppVisibility {

    private var isInBackground = false
    var appVisibilityListener: OnAppVisibilityListener? = null

    override fun onCreate() {
        super.onCreate()
        AppComponentProvider.provideAppComponent(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    override fun appIsInBackground(): Boolean = isInBackground

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        isInBackground =
            !(event == Lifecycle.Event.ON_CREATE || event == Lifecycle.Event.ON_RESUME || event == Lifecycle.Event.ON_START)
        appVisibilityListener?.appVisibility(isInBackground)
    }


}