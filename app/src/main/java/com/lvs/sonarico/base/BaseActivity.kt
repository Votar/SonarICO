package com.lvs.sonarico.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by lipchenko on 25.01.18.
 */
abstract class BaseActivity<V : BaseView, out M : BaseViewModel<V>> : AppCompatActivity(), BaseView {

    abstract val mLayoutId: Int
    abstract val mViewModel: M

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mLayoutId)
    }

    override fun onStart() {
        super.onStart()
        mViewModel.bind(this as V)
    }

    override fun onStop() {
        super.onStop()
        mViewModel.unbind()
    }

}
