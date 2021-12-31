package com.emamagic.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.emamagic.core.extension.findComponent
import timber.log.Timber
import javax.inject.Inject

class FirstFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findComponent<SigninComponentProvider>().provideSigninComponent().inject(this)
        val viewModel = ViewModelProvider(this, viewModelFactory)[FirstViewModel::class.java]

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            val config = viewModel.getConfig()
            Timber.e("onViewCreated: $config")
        }

        view.findViewById<Button>(R.id.btn).setOnClickListener {


        }

    }
}