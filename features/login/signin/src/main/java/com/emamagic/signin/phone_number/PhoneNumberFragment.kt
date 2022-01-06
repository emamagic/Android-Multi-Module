package com.emamagic.signin.phone_number

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.emamagic.core.base.BaseFragment
import com.emamagic.core.extension.findComponent
import com.emamagic.signin.R
import com.emamagic.signin.phone_number.contract.PhoneNumberEvent
import com.emamagic.signin.phone_number.contract.PhoneNumberState
import com.emamagic.signin.databinding.FragmentPhoneNumberBinding
import com.emamagic.signin.di.SigninComponentProvider
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhoneNumberFragment :
    BaseFragment<FragmentPhoneNumberBinding, PhoneNumberState, PhoneNumberEvent, PhoneNumberViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override val viewModel: PhoneNumberViewModel
        get() = ViewModelProvider(this, viewModelFactory)[PhoneNumberViewModel::class.java]

    //override val viewModel by viewModelProvider { ViewModelProvider(this, viewModelFactory)[FirstViewModel::class.java] }

    override fun getResId() = R.layout.fragment_phone_number

    override fun onFragmentCreated(view: View, savedInstanceState: Bundle?) {
        findComponent<SigninComponentProvider>().provideSigninComponent().inject(this)

        lifecycleScope.launch {
            viewModel.getConfig()
        }

        binding.btn.setOnClickListener {
            viewModel.setEvent(PhoneNumberEvent.NavigateToSingUp)
//            viewModel.setEvent(SigninEvent.CustomEvent)
        }

    }


    override fun renderViewState(viewState: PhoneNumberState) {

    }


}