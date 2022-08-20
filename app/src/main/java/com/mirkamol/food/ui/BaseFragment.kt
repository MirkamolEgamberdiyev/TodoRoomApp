package com.mirkamol.food.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment(private val layoutRes: Int) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    fun onBackPressed() {
        findNavController().popBackStack()
    }

//    inline fun View.click(crossinline clickListener: (View) -> Unit) {
//        clicks().onEach {
//            clickListener(this)
//        }.launchIn(MainScope())
//    }

}