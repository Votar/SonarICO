package com.lvs.sonarico.ui.news

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.lvs.sonarico.base.BaseViewModel
import com.lvs.sonarico.network.Api
import com.lvs.sonarico.network.IcoType
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * Created by lipchenko on 25.01.18.
 */
class IcoListViewModel : BaseViewModel<IcoListContract.View>(),
        IcoListContract.ViewModel {

    val icoList: LiveData<List<Int>> = MutableLiveData<List<Int>>()

    override fun load() {
        Api.common.icoList(IcoType.ALL).enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                Timber.d(response.toString())
            }
        })
    }
}