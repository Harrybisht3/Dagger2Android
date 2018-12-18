package com.infy.dagger2kotlin.base

import android.content.Context
import android.support.v4.app.Fragment

import dagger.android.support.AndroidSupportInjection

class BaseFragment : Fragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)

    }
}
