package com.emamagic.android_multi_module

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.emamagic.core.utils.ConnectivityListener
import com.emamagic.android_multi_module.connectivity.NoInternetAvailableDialog
import com.emamagic.android_multi_module.databinding.ActivityMainBinding
import com.emamagic.core.extension.gone
import com.emamagic.core.extension.throttleFirst
import com.emamagic.core.extension.visible
import com.emamagic.network.connectivity.ConnectionLiveData
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import java.util.concurrent.CountDownLatch

class MainActivity : AppCompatActivity(), ConnectivityListener {

    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var binding: ActivityMainBinding
    private lateinit var connectionLiveData: ConnectionLiveData
    private lateinit var connectivityListener: ConnectivityListener
    private val noInternetAvailable = 500L
    private val noInternetAvailableDialogRunnable = Runnable {
        navController.navigate(R.id.action_global_noInternetAvailableDialog)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Android_Multi_Module)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpNavigateUpArrow()
        processNoInternetAvailable()
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.noInternetAvailableDialog -> binding.toolbar.gone()
                else -> binding.toolbar.visible()
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun setUpNavigateUpArrow() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.host_fragment_container) as NavHostFragment
        navController = navHostFragment.findNavController()
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController)
    }

    private fun processNoInternetAvailable() {
        connectivityListener = this
        connectionLiveData = ConnectionLiveData(applicationContext)
        connectionLiveData.observe(this) { isNetworkAvailable ->
            if (!isNetworkAvailable) connectivityListener.phoneHasNoInternet()
        }
    }

    override fun phoneHasNoInternet() {
        binding.root.removeCallbacks(noInternetAvailableDialogRunnable)
        binding.root.postDelayed(noInternetAvailableDialogRunnable, noInternetAvailable)
    }

}