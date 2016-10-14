package cn.yzapp.kotlintest

import cn.yzapp.kotlintest.data.Book
import cn.yzapp.kotlintest.data.User

/**
 * @author: GuSiheng
 * @time: 10/8 008-20:43.
 * @email: gusiheng@qccr.com
 * @desc:
 */
object BaseUse {
    var mUser: User = User(1001)
    fun test(): User {
        mUser.addBook(Book("《怎么让鹿目圆成为魔法少女" + mUser.books.size + "》", mUser.books.size.toLong()))
        return mUser
    }

    class MapConfig(map: Map<String, Any?>) {
        val userName: String by map
        val userId: Long by map
        val book: Book by map
    }

    fun testMapConfig(): MapConfig = MapConfig(mapOf(
            "userName" to "晓美焰",
            "userId" to 2001,
            "book" to Book("《怎么杀死丘比》")
    ))

}