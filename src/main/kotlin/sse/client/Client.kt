package sse.client

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.sse.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
	val client = HttpClient(CIO) {
		install(SSE) // Install SSE client plugin
	}

	client.sse(host = "localhost", port = 8080, path = "/events") {
		// 'incoming' is a Flow<ServerSentEvent>
		incoming.collect { event ->
			println("Received event: ${event.event} -> ${event.data}")
		}
	}

	client.close()
}