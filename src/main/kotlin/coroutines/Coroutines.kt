package com.thoughtworks.bootcamp2025.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.*
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis
import kotlin.time.Duration.Companion.seconds

suspend fun apiCall1(): String {
	delay(1.seconds)
	println("1 Ready")
	throw IllegalArgumentException()
}

suspend fun apiCall2(): String {
	delay(3.seconds)
	println("2 Ready")
	return "API Call 2 Result!"
}

suspend fun main() {
	// Root of the coroutine subtree
	try {
		withContext(Dispatchers.Unconfined) {
			coroutineScope { // this: CoroutineScope
				val milliseconds = measureTimeMillis {
					val resultOf1: Deferred<String> = async { apiCall1() }
					val resultOf2: Deferred<String> = async { apiCall2() }
					val r1String = resultOf1.await()
					val r2String = resultOf2.await()
					println("$r1String & $r2String")
				}
				println("Time to run: $milliseconds")
			}
			// Runs only after all children in the coroutineScope have completed
			println("Coroutine scope completed")
		}
	} catch (e: Exception) {
		println("Exception! $e")
	}

}