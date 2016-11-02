package cn.yzapp.kotlintest

/**
 * @author: GuSiheng
 * @time: 11/2 002-16:09.
 * @email: gusiheng@qccr.com
 * @desc:
 */
class CustomLambdas(var listener: (String) -> Unit) {
    fun changeContent(newContent: String) {
        listener.invoke(newContent)
    }
}