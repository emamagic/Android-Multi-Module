package com.emamagic.safe.policy

data class RetryPolicy(
   val times: Int = 5,
   val initialDelay: Long = 1000,
   val maxDelay: Long = 10000,
   val factor: Double = 2.0,
)