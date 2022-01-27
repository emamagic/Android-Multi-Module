package com.emamagic.common_jvm

import java.io.IOException

class NoInternetException(message: String? = null): IOException(message)
class ServerConnectionException(message: String? = null): IOException(message)