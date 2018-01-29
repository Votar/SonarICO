package com.lvs.sonarico.ui.news

import com.lvs.sonarico.base.BaseModel
import com.lvs.sonarico.base.BaseView

/**
 * Created by lipchenko on 25.01.18.
 */
interface IcoListContract {
    interface View : BaseView {
        fun showProgress()
        fun hideProgress()
    }

    interface ViewModel : BaseModel {
        fun load()
    }
}