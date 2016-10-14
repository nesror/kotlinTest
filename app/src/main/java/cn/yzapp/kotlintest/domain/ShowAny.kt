package cn.yzapp.kotlintest.domain

import com.google.gson.Gson

/**
 * @author: nestor
 */
class ShowAny<out T>(val any: T, val gson: Gson = Gson()) {
    fun show(): String = gson.toJson(any)
}