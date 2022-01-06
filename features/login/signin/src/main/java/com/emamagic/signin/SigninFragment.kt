package com.emamagic.signin

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.emamagic.core.base.BaseFragment
import com.emamagic.core.extension.findComponent
import com.emamagic.signin.contract.SiginEvent
import com.emamagic.signin.contract.SigninState
import com.emamagic.signin.databinding.FragmentPhoneNumberBinding
import com.emamagic.signin.di.SigninComponentProvider
import kotlinx.coroutines.launch
import javax.inject.Inject

class SigninFragment :
    BaseFragment<FragmentPhoneNumberBinding, SigninState, SiginEvent, SigninViewModel>() {

    override val viewModel: SigninViewModel
        get() = ViewModelProvider(this, viewModelFactory)[SigninViewModel::class.java]

    //override val viewModel by viewModelProvider { ViewModelProvider(this, viewModelFactory)[FirstViewModel::class.java] }

    override fun getResId() = R.layout.fragment_phone_number

    override fun onFragmentCreated(view: View, savedInstanceState: Bundle?) {
        findComponent<SigninComponentProvider>().provideSigninComponent().inject(this)

        binding.btn.setOnClickListener {
            viewModel.setEvent(SiginEvent.NavigateToSingUp)
//            viewModel.setEvent(SigninEvent.CustomEvent)
        }

    }


    override fun renderViewState(viewState: SigninState) {

    }


}