package com.emamagic.signin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.emamagic.core.base.BaseEffect
import com.emamagic.core.base.BaseFragment
import com.emamagic.core.extension.findComponent
import com.emamagic.signin.contract.SigninEvent
import com.emamagic.signin.contract.SigninState
import com.emamagic.signin.databinding.FragmentFirstBinding
import com.emamagic.signin.di.SigninComponentProvider
import kotlinx.coroutines.launch

class FirstFragment : BaseFragment<FragmentFirstBinding, SigninState, SigninEvent, FirstViewModel>() {

    override val viewModel: FirstViewModel
        get() = ViewModelProvider(this, viewModelFactory)[FirstViewModel::class.java]


    override fun getResId() = R.layout.fragment_first

    override fun onFragmentCreated(view: View, savedInstanceState: Bundle?) {
        findComponent<SigninComponentProvider>().provideSigninComponent().inject(this)

        lifecycleScope.launch {
            viewModel.getConfig()
        }

        binding.btn.setOnClickListener {
            viewModel.setEvent(SigninEvent.NavigateToSingUp)
//            viewModel.setEvent(SigninEvent.CustomEvent)
        }

    }


    override fun renderViewState(viewState: SigninState) {

    }


}