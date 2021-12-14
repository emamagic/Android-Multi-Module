package com.emamagic.signin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class FirstFragment: Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(requireContext(), "hiiiii", Toast.LENGTH_SHORT).show()

        view.findViewById<Button>(R.id.btn).setOnClickListener {
        }


    }
}