package cn.yzapp.kotlintest.data

import java.util.*
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * @author: GuSiheng
 * 委托不能放在bean里不然Gson转换无效
 */
class User(var id: Long){
    // 使用委托后Gson转换无效！！
    var name: String by MyDelegate()

    var books = ArrayList<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    var showChineseName by Delegates.observable(false) {
        d, old, new ->
        name = if (new) "丘比" else "Incubator"
    }
}

class MyDelegate() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        if(prop.)
        return "$thisRef, thank you for delegating '${prop}' to me!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        println("$value has been assigned to ${prop.name} in $thisRef")
    }
}

class Book(var name: String = "", var id: Long = 0)