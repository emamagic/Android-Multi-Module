package com.emamagic.signin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.emamagic.common_android.di.DaggerSigninComponent
import com.emamagic.common_android.extension.findAppComponent
import kotlinx.coroutines.launch

class FirstFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn).setOnClickListener {
        }
        val signinComponent = DaggerSigninComponent.builder().appComponent(findAppComponent()).build()
        val getConfig = signinComponent.getConfigUi()

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            val config = getConfig()

            Log.e("TAG", "onCreate: ${config.data}")
            Log.e("TAG", "onCreate: ${config.code}")
            Log.e("TAG", "onCreate: ${config.error}")
        }

    }
}