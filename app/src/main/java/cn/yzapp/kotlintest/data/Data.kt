package cn.yzapp.kotlintest.data

import android.util.Log
import java.util.*
import kotlin.properties.Delegates

/**
 * @author: GuSiheng
 * 委托不能放在bean里不然Gson转换无效
 */
class User(var id: Long) {
    // 使用委托后Gson转换无效！！
    var name: String by Delegates.vetoable("Incubator") {
        d, old, new ->
        Log.d(javaClass.simpleName, new)
        new.length > 1
    }

    /*var nameJson: String = ""
        get() = name
        set(value) {
            field = value
            name = value
        }*/

    var books = ArrayList<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    var showChineseName by Delegates.observable(false) {
        d, old, new ->
        name = if (new) "丘比" else "Incubator"
    }
}

class Book(var name: String = "", var id: Long = 0)