package cn.yzapp.kotlintest.ui

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import cn.yzapp.kotlintest.utils.SharedPreferencesUtils
import com.bumptech.glide.Glide

open class BaseActivity : AppCompatActivity() {

    // 标准委托:惰加载
    val sp: SharedPreferencesUtils by lazy {
        SharedPreferencesUtils(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // 扩展函数
    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

    // 和Context.toast效果一样但不是扩展函数,原理上不一样
    fun toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(applicationContext, message, duration).show()
    }

    // 另一些扩展函数
    fun View.snackbar(message: CharSequence, duration: Int = Snackbar.LENGTH_SHORT): Snackbar {
        return Snackbar.make(this, message, duration)
    }

    fun Log.d(log: String) {
        Log.d(this.javaClass.simpleName, log)
    }

    fun ImageView.load(url: String) {
        Glide.with(this.context).load(url).into(this)
    }
}
