package sse

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.server.sse.*
import kotlinx.coroutines.flow.flow

fun main() {
	embeddedServer(Netty, port = 18080) {
		// 1. Install the SSE plugin
		install(SSE)

		routing {
			// 2. Define the SSE route
			sse("/events") {
				// This block runs within a ServerSSESession

				// Create a Flow emitting each tick, with a 1s delay
				val tickFlow = flow<String> {
					repeat(10) {
						TODO()
					}
				}

				/*
				3. Collect the flow and emit events to the client, via a ServerSentEvent
				with `data`, `event` and `id` fields populated.
				*/
				tickFlow.collect { TODO() }

				// The connection closes automatically when the block finishes.
				// To keep it open indefinitely (e.g., for a chat), use `awaitCancellation()`
				// or infinite loops while collecting a hot flow (SharedFlow).
			}
		}
	}.start(wait = true)
}