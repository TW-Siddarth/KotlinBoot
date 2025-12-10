package com.thoughtworks.bootcamp2025.async

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation as ClientContentNegotiation

import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.install
import io.ktor.server.application.log
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation as ServerContentNegotiation
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.Serializable

@Serializable
data class AggregatedResponse(val user: User, val products: List<Product>)


fun main() {
	embeddedServer(Netty, port = 18081) {
		install(ServerContentNegotiation) {
			json()
		}

		// Ktor client for making external HTTP requests
		val client = HttpClient(CIO) {
			install(ClientContentNegotiation) {
				json()
			}
		}

		routing {
			get("/user-products/{userId}") {
				val userId = call.parameters["userId"] ?: return@get call.respondText("User ID not provided")
				log.info("Called for user $userId")

				try {
					// Use coroutineScope to manage the lifecycle of the launched coroutines
					coroutineScope {
						val user = async { client.get("http://localhost:18082/users/$userId").body<User>() }
						val products = async { client.get("http://localhost:18082/products?userId=$userId").body<List<Product>>() }
						val response = AggregatedResponse(user.await(), products.await())
						call.respond(response)
					}
				}
				catch (e: CancellationException) {
					log.error("CancellationException", e)
					throw(e)
				}
				catch (e: Exception) {
					log.error("Exception!", e)
					call.respondText("An error occurred: ${e.message}")
				}
			}
		}
	}.start(wait = true)
}