package cn.yzapp.kotlintest.kotlin

/**
 * Created by Nestor on 11/02 030.
 * lambdas匿名函数
 */
class CustomLambdas(var listener: (String) -> Unit) {
    fun changeContent(newContent: String) {
        listener.invoke(newContent)
    }
}