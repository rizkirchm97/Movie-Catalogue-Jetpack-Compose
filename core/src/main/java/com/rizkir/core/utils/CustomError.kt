package com.rizkir.core.utils

import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

fun message(throwable: Throwable?):String{
    when (throwable) {
        is SocketTimeoutException -> return "Whoops! Connection time out. Please try again"
        is IOException -> return "Whoops! No Internet Connection. Please try again"
        is HttpException -> return try {
            throwable.response()?.errorBody().toString()
        }catch (e:Exception){
            "Whoops! Unknown error occurred. Please try again"
        }
    }
    return "Whoops! Unknown error occurred. Please try again"
}

fun code(throwable: Throwable?):Int{
    return if (throwable is HttpException) (throwable).code()
    else  0
}