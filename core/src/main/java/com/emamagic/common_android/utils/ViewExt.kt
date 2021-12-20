package com.emamagic.common_android.utils

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager

inline fun EditText.onTextChange(crossinline listener: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            listener(s.toString())
        }
    })
}

inline fun DrawerLayout.onDrawerListener(crossinline listener: (Float, View) -> Unit) {
    this.addDrawerListener(object: DrawerLayout.DrawerListener{
        override fun onDrawerSlide(drawerView: View, slideOffset: Float) { listener(slideOffset ,drawerView) }
        override fun onDrawerOpened(drawerView: View) {}
        override fun onDrawerClosed(drawerView: View) {}
        override fun onDrawerStateChanged(newState: Int) {}
    })
}

val <T> T.exhaustive: T
    get() = this


private fun FragmentManager.isOnBackStack(backStackName: String): Boolean {
    val backStackCount = backStackEntryCount
    for (index in 0 until backStackCount) {
        if (getBackStackEntryAt(index).name == backStackName) {
            return true
        }
    }
    return false
}