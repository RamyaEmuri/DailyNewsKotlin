package com.ci.notesapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    private var itemView: View? = null
    abstract fun setLayout(): Int

    abstract fun initView(savedInstanceState: Bundle?)

    fun getItemView():View?{
        return itemView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         itemView = inflater.inflate(setLayout(), container, false)
        return itemView
    }
}