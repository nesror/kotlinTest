package cn.yzapp.kotlintest.ui

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

    fun Activity.snackbar(view: View, message: CharSequence, duration: Int = Snackbar.LENGTH_SHORT): Snackbar {
        return Snackbar.make(view, duration, duration)
    }
}
