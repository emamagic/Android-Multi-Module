package com.emamagic.core.interfaces

// for safe modules that call initial functions of visible fragment when user comes to online
interface InitialVisibleFragmentFun {
    fun onInitialFunctions(pair: Pair<List<suspend () -> Unit>, Long>)
}