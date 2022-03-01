package com.emamagic.core.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

inline fun <VM : ViewModel> viewModelFactory(
    crossinline f: () -> VM
) =
    object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(aClass: Class<T>) =
            f() as T
    }

//inline fun <reified VM : ViewModel> Fragment.viewModelProvider(
//    crossinline provider: () -> VM) = lazy {
//    ViewModelProvider(this, object : ViewModelProvider.Factory {
//        override fun <T1 : ViewModel> create(aClass: Class<T1>) =
//            provider() as T1
//    }).get(VM::class.java)
//}

inline fun <reified VM : ViewModel> Fragment.viewModelProvider(
    mode: LazyThreadSafetyMode = LazyThreadSafetyMode.NONE,
    crossinline provider: () -> VM) = lazy(mode) {
    ViewModelProvider(this, object : ViewModelProvider.Factory {
        override fun <T1 : ViewModel> create(aClass: Class<T1>) =
            provider() as T1
    }).get(VM::class.java)
}