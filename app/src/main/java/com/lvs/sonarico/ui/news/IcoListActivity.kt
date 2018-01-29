package com.lvs.sonarico.ui.news

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.widget.SwipeRefreshLayout
import com.lvs.sonarico.R
import com.lvs.sonarico.base.BaseActivity
import kotlinx.android.synthetic.main.activity_ico_list.*

/**
 * Created by lipchenko on 25.01.18.
 */
class IcoListActivity : BaseActivity<IcoListContract.View, IcoListViewModel>(), IcoListContract.View {

    override val mLayoutId: Int
        get() = R.layout.activity_ico_list
    override val mViewModel: IcoListViewModel
        get() = ViewModelProviders.of(this).get(IcoListViewModel::class.java)

    val mRefresh: SwipeRefreshLayout by lazy { a_ico_list_refresh }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ico_list)
    }
    override fun onStart() {
        super.onStart()
        mViewModel.load()
    }

    override fun showProgress() {
        mRefresh.isRefreshing = true
    }

    override fun hideProgress() {
        mRefresh.isRefreshing = false
    }

}