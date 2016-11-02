package cn.yzapp.kotlintest

import cn.yzapp.kotlintest.data.Book
import cn.yzapp.kotlintest.data.User

/**
 * Created by Nestor on 10/31 030.
 * object 相当于静态类
 */
object BaseUse {
    var mUser: User = User(1001)
    fun test(): User {
        mUser.addBook(Book("《怎么让鹿目圆成为魔法少女" + mUser.books.size + "》", mUser.books.size.toLong()))
        return mUser
    }

    // 标准委托:以 Map 形式保存属性的值
    class MapConfig(map: MutableMap<String, Any?>) {
        var userName: String by map
        var userId: Long by map
        var book: Book by map
    }

    fun testMapConfig(): MapConfig = MapConfig(mutableMapOf(
            "userName" to "晓美焰",
            "userId" to 2001,
            "book" to Book("《怎么杀死丘比》")
    ))

}