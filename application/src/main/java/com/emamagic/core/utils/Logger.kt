package com.emamagic.core.utils

import android.util.Log
import com.emamagic.core.BuildConfig
import java.lang.Exception

object Logger {

    private val TAG: String = Logger::class.simpleName ?: "CLASS NAME IS NULL"
    private val DEBUG: Boolean = BuildConfig.DEBUG

    private fun e(tag: String, text: Any?) {
        if (!DEBUG) {
            return
        }
        Log.e(tag, text?.toString() ?: "LOGGER IS NULL") //avoid null
    }

    fun d(tag: String, text: Any?) {
        if (!DEBUG) {
            return
        }
        Log.d(tag, text?.toString() ?: "LOGGER IS NULL") //avoid null
    }

    fun d(tag: String, text: Any?, throwable: Throwable?) {
        if (!DEBUG) {
            return
        }
        Log.d(tag, text?.toString() ?: "LOGGER IS NULL", throwable) //avoid null
    }

    fun i(tag: String, text: Any?) {
        if (!DEBUG) {
            return
        }
        Log.i(tag, text?.toString() ?: "LOGGER IS NULL") //avoid null
    }

    fun throwable(throwable: Throwable) {
        if (!DEBUG) {
            return
        }
        throwable.printStackTrace()
    }

    fun exception(exception: Exception) {
        if (!DEBUG) {
            return
        }
        exception.printStackTrace()
    }

    fun exception(throwable: Throwable) {
        if (!DEBUG) {
            return
        }
        throwable.printStackTrace()
    }

    fun d(text: Any?) {
        d(getCurrentClassName() + " || " + getCurrentMethodName(), text) //avoid null
    }

    fun i(text: Any?) {
        i(getCurrentClassName() + " || " + getCurrentMethodName(), text) //avoid null
    }

    fun e(vararg objects: Any?) {
        if (objects.isNotEmpty()) {
            e(getCurrentClassName() + " || " + getCurrentMethodName(), objects.contentToString())
        } else {
            e(getCurrentClassName() + " || " + getCurrentMethodName(), getCurrentMethodName())
        }
    }

    fun e(objects: List<Any?>?) {
        if (objects != null) {
            e(
                getCurrentClassName() + " || " + getCurrentMethodName(),
                objects.toTypedArray().contentToString()
            )
        } else {
            e(TAG, null)
        }
    }

    private fun getCurrentMethodName(): String {
        try {
            return Thread.currentThread().stackTrace[4].methodName + "()"
        } catch (ignored: Exception) {
        }
        return TAG
    }

    private fun getCurrentClassName(): String {
        try {
            var className = Thread.currentThread().stackTrace[4].className
            val temp = className.split("[.]".toRegex()).toTypedArray()
            className = temp[temp.size - 1]
            return className
        } catch (ignored: Exception) {
        }
        return TAG
    }

}