package cn.yzapp.kotlintest.data

import cn.yzapp.kotlintest.kotlin.debug
import java.util.*
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * @author: nestor
 * 委托不能放在bean里不然Gson转换无效
 */
class User(var id: Long) {
    // 自定义委托
    var name: String by MyDelegate()

    var books = ArrayList<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    // 标准委托:观察者模式
    var showChineseName by Delegates.observable(false) {
        d, old, new ->
        name = if (new) "丘比" else "Incubator"
    }

}

// 自定义委托
class MyDelegate() {
    var delegateName: String = ""
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        debug(" $thisRef 把 ${prop.name} 委托给我")
        return delegateName
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        debug("在 $thisRef 中把 $value 分配给 ${prop.name}")

        // 名字多余1个才有效
        if (value.length > 1) {
            delegateName = value
        }

    }
}

class Book(var name: String = "", var id: Long = 0)