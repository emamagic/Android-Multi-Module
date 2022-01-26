package com.emamagic.core.extension

import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.emamagic.core.utils.ConnectivityListener
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import java.util.*

inline fun <reified SubComponentProvider> Context.findComponent(): SubComponentProvider {
    return if (applicationContext is SubComponentProvider) {
        (applicationContext as SubComponentProvider)
    } else {
        throw IllegalStateException("Provide the application context which implement SubComponent")
    }
}

inline fun <reified SubComponentProvider> View.findComponent(): SubComponentProvider = context.findComponent()

inline fun <reified SubComponentProvider> Fragment.findComponent(): SubComponentProvider = requireContext().findComponent()

fun Fragment.phoneHasNoInternet() {
     (requireActivity() as ConnectivityListener).phoneHasNoInternet()
}

fun <T> Flow<T>.throttleFirst(periodMillis: Long): Flow<T> {
    require(periodMillis > 0) { "period should be positive" }
    return flow {
        var lastTime = 0L
        collect { value ->
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastTime >= periodMillis) {
                lastTime = currentTime
                emit(value)
            }
        }
    }
}
