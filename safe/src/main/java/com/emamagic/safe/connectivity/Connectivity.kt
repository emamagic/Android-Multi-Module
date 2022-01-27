package com.emamagic.safe.connectivity

import com.emamagic.safe.Const

class Connectivity(val status: Int, val callback: (() -> Unit?)? = null) {
    companion object {
        val IDS = listOf(Const.CONNECT, Const.DISCONNECT, Const.OFFLINE_MODE)
    }
}