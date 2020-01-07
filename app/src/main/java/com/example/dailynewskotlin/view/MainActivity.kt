package com.example.dailynewskotlin.view

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.ci.notesapp.base.BaseActivity
import com.example.dailynewskotlin.R
import com.example.dailynewskotlin.adapters.MainAdapter
import com.example.dailynewskotlin.fragments.ViewFragment
import com.example.dailynewskotlin.presenters.MainActivityPresenter
import com.example.dailynewskotlin.presenters.NewsInterface
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), NewsInterface {

    lateinit var mainAdapter: MainAdapter

    lateinit var progerssProgressDialog: ProgressDialog

    val presenter: MainActivityPresenter = MainActivityPresenter(this)
    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {

        recyclerView_1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        progerssProgressDialog = ProgressDialog(this)
        progerssProgressDialog.setTitle("Loading")
        progerssProgressDialog.setCancelable(false)
        progerssProgressDialog.show()

        presenter.callApi()
        setUpView()
    }

    override fun showResult(body: Test) {
//        showSnackBar("Successfully")
        mainAdapter = MainAdapter(body.response.docs)
        recyclerView_1.adapter = mainAdapter
        progerssProgressDialog.dismiss()
    }


    private fun setUpView(){

        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(ViewFragment(), "Newest")
        adapter.addFragment(ViewFragment(),"Popular")
        adapter.addFragment(ViewFragment(), "Featured")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

    }

    private class ViewPagerAdapter(manager: FragmentManager) :
        FragmentPagerAdapter(manager) {
        private var childFragments: ArrayList<Fragment> = ArrayList()
        private val mFragmentTitleList: ArrayList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return childFragments.get(position)
        }

        override fun getCount(): Int {
            return childFragments.size
        }
        override fun getPageTitle(position: Int): CharSequence? {
           return when (position) {
                0 -> return "Newest"
                1 -> return "Popular"
                else -> return "Featured"
            }
        }

        fun addFragment(fragment: Fragment, title:String){
            childFragments.add(fragment)
            mFragmentTitleList.add(title)
        }
    }
}
