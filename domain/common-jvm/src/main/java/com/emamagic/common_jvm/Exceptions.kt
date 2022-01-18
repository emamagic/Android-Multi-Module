package com.emamagic.common_jvm

import java.io.IOException

class NoInternetException(message: String): IOException(message)
class ServerException(message: String): IOException(message)