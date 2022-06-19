package com.ruben.exceptioncatcher.base

import io.sentry.Sentry

/**
 * Created by Ruben Quadros on 19/06/22
 **/
fun Throwable?.captureException() {
    this?.let { Sentry.captureException(it) }
}