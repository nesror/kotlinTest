package cn.yzapp.kotlintest.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cn.yzapp.kotlintest.utils.SharedPreferencesUtils

open class BaseActivity : AppCompatActivity() {

    // 标准委托:惰加载（避免使用单例）
    val sp: SharedPreferencesUtils by lazy {
        SharedPreferencesUtils(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}
