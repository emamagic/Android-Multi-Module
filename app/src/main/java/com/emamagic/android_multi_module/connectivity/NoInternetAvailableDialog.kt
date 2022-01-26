package com.emamagic.android_multi_module.connectivity

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.emamagic.android_multi_module.R
import com.emamagic.android_multi_module.databinding.FragmentNoInternetAvailableBinding

class NoInternetAvailableDialog: DialogFragment() {

    private var _binding: FragmentNoInternetAvailableBinding? = null
    private val binding: FragmentNoInternetAvailableBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        setStyle(STYLE_NORMAL, R.style.AppTheme_FullScreenDialog)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_no_internet_available, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnOk.setOnClickListener { findNavController().navigateUp() }
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}