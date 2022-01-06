package com.emamagic.signup

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

class SignupFragment: Fragment(R.layout.fragment_second_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(requireContext(), "how are you", Toast.LENGTH_SHORT).show()

    }

}