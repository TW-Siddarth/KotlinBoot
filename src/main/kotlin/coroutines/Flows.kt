package com.thoughtworks.bootcamp2025.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flow

fun createFlow() = flow<Int> {
	for (i in 1..10) {
		println("[${Thread.currentThread().name}] Emitting $i")
		emit(i)
	}
}

suspend fun main() {
	coroutineScope {
		val flow = createFlow()
		flow.collect {
			println("[${Thread.currentThread().name}] $it is collected")
		}
	}
}