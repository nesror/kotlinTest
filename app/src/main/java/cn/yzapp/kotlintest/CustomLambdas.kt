package cn.yzapp.kotlintest

/**
 * Created by Nestor on 11/02 030.
 * lambdas匿名函数
 */
class CustomLambdas(var listener: (String) -> Unit) {
    fun changeContent(newContent: String) {
        listener.invoke(newContent)
    }
}