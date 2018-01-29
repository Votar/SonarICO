package com.lvs.sonarico.base

import android.arch.lifecycle.ViewModel

/**
 * Created by lipchenko on 25.01.18.
 */
abstract class BaseViewModel<V : BaseView> : ViewModel(), BaseModel {

    var mView: V? = null

    fun bind(view: V) {
        mView = view
    }

    fun unbind() {
        mView = null
    }

}