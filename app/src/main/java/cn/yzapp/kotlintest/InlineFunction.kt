package cn.yzapp.kotlintest

import android.util.Log

/**
 * Created by Nestor on 10/31 030.
 * 内联函数
 */
// reified 在Kotlin中， 一个内联（inline） 函数可以被具体化（reified）， 这意味着我们可以在函数中得到并使用范型类型的Class
inline fun <reified T> T.debug(log: Any) {
    Log.d(T::class.simpleName, log.toString())
}