package com.emamagic.android_multi_module

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ConnectivityReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // for enable or disable offline mode from every feature that send the broadcast
    }
}