package cn.yzapp.kotlintest.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import cn.yzapp.kotlintest.BaseUse
import cn.yzapp.kotlintest.R
import cn.yzapp.kotlintest.data.User
import cn.yzapp.kotlintest.domain.ShowAny
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*
import kotlin.properties.Delegates

class MainActivity : BaseActivity() {

    var mUser: User by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        setSupportActionBar(toolbar)

        mUser = BaseUse.test()
        mUser.name = "dsgfdg"

        init()
    }

    private fun init() {
        tvBook.text = ShowAny(mUser).show()

        fab.setOnClickListener { view ->
            mUser = BaseUse.test()
            snackbar(view, "用第" + mUser.books.size + "种方式").setAction("CLEAR", {
                mUser.books.clear()
                tvBook.text = ShowAny(mUser).show()
            }).show()
            tvBook.text = ShowAny(mUser).show()
        }

        tvKill.setOnClickListener {
            tvBook.text = ShowAny(BaseUse.testMapConfig()).show()
            toast("tvKill")
        }

        changeName.setOnClickListener {
            mUser.showChineseName = !mUser.showChineseName
            tvBook.text = mUser.name
            toast("changeName")
        }
    }

}
