package cn.yzapp.kotlintest.utils

import android.content.Context

/**
 * Created by Nestor on 10/30 030.
 */
class SharedPreferencesUtils(context: Context) {
    companion object {
        val SP_NAME = "config"
    }

    val sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

    fun put(key: String, value: String) {
        sp.edit().putString(key, value).apply()
    }

    fun get(key: String): String = sp.getString(key, "")

}