package com.rizkir.di.utils

import javax.inject.Qualifier

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.TYPE, AnnotationTarget.FILE)
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ImageBaseUrl
