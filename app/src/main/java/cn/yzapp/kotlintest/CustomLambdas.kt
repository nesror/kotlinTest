package cn.yzapp.kotlintest

/**
 * Created by Nestor on 10/31 030.
 * lambdas匿名函数
 */
class CustomLambdas(var listener: (String) -> Unit) {
    fun changeContent(newContent: String) {
        listener.invoke(newContent)
    }
}