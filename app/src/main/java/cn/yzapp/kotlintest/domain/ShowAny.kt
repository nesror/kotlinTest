package cn.yzapp.kotlintest.domain

import com.google.gson.Gson

/**
 * @author: GuSiheng
 * @time: 10/12 012-11:27.
 * @email: gusiheng@qccr.com
 * @desc:
 */
class ShowAny<out T>(val any: T, val gson: Gson = Gson()) {
    fun show(): String = gson.toJson(any)
}