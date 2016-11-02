package cn.yzapp.kotlintest.ui

import android.os.Bundle
import cn.yzapp.kotlintest.*
import cn.yzapp.kotlintest.data.User
import cn.yzapp.kotlintest.domain.ShowAny
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*
import kotlin.properties.Delegates

class MainActivity : BaseActivity() {

    companion object {
        val BOOK = "BOOK"
    }

    // 标准委托:notNull
    var mUser: User by Delegates.notNull()
    var mCustomLambdas: CustomLambdas by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        setSupportActionBar(toolbar)

        mUser = BaseUse.test()

        init()
    }

    private fun init() {

        // lambdas匿名函数
        mCustomLambdas = CustomLambdas ({ s ->
            bookList.text = s
        })

        // 类，构造函数
        bookList.text = ShowAny(mUser).show()

        fab.setOnClickListener { view ->
            mUser = BaseUse.test()
            // 使用了扩展函数
            view.snackbar("用第" + mUser.books.size + "种方式").setAction("CLEAR", {
                mUser.books.clear()
                bookList.text = ShowAny(mUser).show()
            }).show()
            bookList.text = ShowAny(mUser).show()
        }

        killQb.setOnClickListener {
            // 标准委托:以 Map 形式保存属性的值
            bookList.text = BaseUse.testMapConfig().userName + BaseUse.testMapConfig().book.name
            toast("killQb")

        }

        changeName.setOnClickListener {
            // 标准委托:观察者模式
            mUser.showChineseName = !mUser.showChineseName
            bookList.text = mUser.name
            toast("changeName")
        }

        saveBook.setOnClickListener {
            // 标准委托:惰加载
            sp.put(BOOK, bookList.text.toString())
        }

        showBook.setOnClickListener {
            bookList.text = sp.get(BOOK)
        }

        lambdas.setOnClickListener {
            mCustomLambdas.changeContent("lambdas")
        }

        // 通过扩展函数使imageview可以直接加载网络图片
        img.load("http://img1.mydrivers.com/img/20161030/29f3e60b5f33428fbecb034a8db38978.jpg")

    }


}
