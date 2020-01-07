package com.example.dailynewskotlin.fragments

import android.app.ProgressDialog
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ci.notesapp.base.BaseFragment
import com.example.dailynewskotlin.R
import com.example.dailynewskotlin.adapters.AdapterTwo
import com.example.dailynewskotlin.adapters.MainAdapter
import com.example.dailynewskotlin.presenters.MainActivityPresenter
import com.example.dailynewskotlin.presenters.NewsInterface
import com.example.dailynewskotlin.view.Test
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class ViewFragment: BaseFragment(), NewsInterface {
    lateinit var progerssProgressDialog: ProgressDialog
    lateinit var adapterTwo: AdapterTwo

    val presenter: MainActivityPresenter = MainActivityPresenter(this)

    override fun setLayout(): Int {
        return R.layout.fragment_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        recyclerView_2.layoutManager =
            LinearLayoutManager(activity)

//        progerssProgressDialog = ProgressDialog(context)
//        progerssProgressDialog.setTitle("Loading")
//        progerssProgressDialog.setCancelable(false)
//        progerssProgressDialog.show()

        presenter.callApi()
    }

    override fun showResult(body: Test) {


        adapterTwo = AdapterTwo(body.response.docs)
        recyclerView_2.adapter = adapterTwo
//        progerssProgressDialog.dismiss()
    }
}