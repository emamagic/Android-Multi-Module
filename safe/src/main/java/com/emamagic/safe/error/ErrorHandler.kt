package com.emamagic.safe.error

import com.emamagic.common_jvm.ErrorEntity

interface ErrorHandler {
    fun getError(throwable: Throwable): ErrorEntity
}