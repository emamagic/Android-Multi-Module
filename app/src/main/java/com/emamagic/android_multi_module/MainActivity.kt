package com.emamagic.android_multi_module

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.emamagic.android_multi_module.databinding.ActivityMainBinding
import com.emamagic.core.extension.gone
import com.emamagic.core.extension.visible
import com.emamagic.safe.connectivity.ConnectionLiveData
import com.emamagic.safe.connectivity.ConnectivityStatus

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var binding: ActivityMainBinding
    private lateinit var connectionLiveData: ConnectionLiveData


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

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter("com.emamagic.test")
        registerReceiver(connectivityReceiver, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(connectivityReceiver)
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
        connectionLiveData = ConnectionLiveData(applicationContext)
        connectionLiveData.observe(this) { status ->
            if (status == ConnectivityStatus.DISCONNECT && findVisibleFragmentName() != NoInternetAvailableDialog::class.simpleName)
                navController.navigate(R.id.action_global_noInternetAvailableDialog)
            else if (status == ConnectivityStatus.CONNECT && findVisibleFragmentName() == NoInternetAvailableDialog::class.simpleName)
                navController.navigateUp()
        }
    }

    private fun findVisibleFragmentName(): String =
        navHostFragment.childFragmentManager.fragments[0]::class.simpleName!!


    private val connectivityReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            // for enable or disable offline mode from every feature that send the broadcast
            // TODO() for test
            connectionLiveData.enableOfflineMode()
            connectionLiveData.disableOfflineMode()
        }
    }

}