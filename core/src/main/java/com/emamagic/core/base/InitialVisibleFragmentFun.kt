package com.emamagic.core.base

// for safe modules that call initial functions of visible fragment when user comes to online
interface InitialVisibleFragmentFun {
    fun onInitialFunctions(functions: List<suspend () -> Unit>)
}