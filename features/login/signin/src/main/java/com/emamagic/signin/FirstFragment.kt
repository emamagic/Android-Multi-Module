package com.emamagic.signin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.emamagic.core.extension.findAppComponent
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

        DaggerSigninComponent.builder().appComponent(findAppComponent()).build().inject(this)
        val vm = ViewModelProvider(this, viewModelFactory)[FirstViewModel::class.java]

        Log.e("TAG", "onViewCreated: ${vm.test.hashCode()}")
        view.findViewById<Button>(R.id.btn).setOnClickListener {


        }


//        val useCase = findAppComponent().getSigninComponent().getFirstFragmentUseCase()

//        Log.e("TAG", "onViewCreated: ${useCase.hashCode()}")

    }
}