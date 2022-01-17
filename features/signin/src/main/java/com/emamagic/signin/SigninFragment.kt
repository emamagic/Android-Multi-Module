package com.emamagic.signin

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.emamagic.core.base.BaseFragment
import com.emamagic.core.extension.findComponent
import com.emamagic.signin.contract.SigninEvent
import com.emamagic.signin.contract.SigninState
import com.emamagic.signin.databinding.FragmentSigninBinding
import com.emamagic.signin.di.SigninComponentProvider

class SigninFragment :
    BaseFragment<FragmentSigninBinding, SigninState, SigninEvent, SigninViewModel>() {

    override val viewModel: SigninViewModel
        get() = ViewModelProvider(this, viewModelFactory)[SigninViewModel::class.java]

    //override val viewModel by viewModelProvider { ViewModelProvider(this, viewModelFactory)[FirstViewModel::class.java] }

    override fun getResId() = R.layout.fragment_signin

    override fun onFragmentCreated(view: View, savedInstanceState: Bundle?) {
        findComponent<SigninComponentProvider>().provideSigninComponent().inject(this)

        binding.btnLogin.setOnClickListener { viewModel.setEvent(SigninEvent.NavigateToHome) }

    }


    override fun renderViewState(viewState: SigninState) {

    }


}