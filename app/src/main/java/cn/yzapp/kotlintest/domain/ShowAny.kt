package cn.yzapp.kotlintest.domain

import android.util.Log
import com.google.gson.Gson

/**
 * @author: nestor
 */
class ShowAny<out T>(val any: T, val gson: Gson = Gson()) {
    init {
        Log.d(javaClass.simpleName, any.toString())
    }

    fun show(): String = gson.toJson(any)
}