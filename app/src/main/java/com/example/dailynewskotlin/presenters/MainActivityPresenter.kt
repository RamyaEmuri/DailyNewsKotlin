package com.example.dailynewskotlin.presenters

import android.util.Log
import com.example.dailynewskotlin.interfaces.RetrofitClass
import com.example.dailynewskotlin.view.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityPresenter(val newsInterface: NewsInterface) {

    fun callApi() {
        val call = RetrofitClass.getClient()?.doGetListResources()
        call?.enqueue(object : Callback<Test> {
            override fun onFailure(call: Call<Test>?, t: Throwable?) {
                Log.e("Test",t?.message)
            }

            override fun onResponse(
                call: Call<Test>?,
                response: Response<Test>
            ) {

                newsInterface.showResult(response?.body())
            }
        })
    }
}



