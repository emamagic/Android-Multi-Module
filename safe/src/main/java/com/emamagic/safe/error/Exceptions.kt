package com.emamagic.safe.error

import java.io.IOException

class NoInternetException(message: String): IOException(message)
class ServerConnectionException(message: String): IOException(message)