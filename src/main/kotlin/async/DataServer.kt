package com.thoughtworks.bootcamp2025.async

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
	// Start an embedded Netty server on port 18082
	embeddedServer(Netty, port = 18082) {
		// Install the ContentNegotiation plugin to automatically handle JSON
		install(ContentNegotiation) {
			json() // Using kotlinx.serialization for JSON
		}

		// Define the routes for the server
		routing {
			// Endpoint to get user information by ID
			get("/users/{userId}") {
				val id = call.parameters["userId"] ?: "unknown"
				println("Received request for user: $id")

				// For demonstration, return a hardcoded User object
				val user = User(id, "Jane Doe")
				call.respond(user)
			}

			// Endpoint to get a list of products for a user
			get("/products") {
				val userId = call.request.queryParameters["userId"] ?: "unknown"
				println("Received request for products for user: $userId")

				// For demonstration, return a hardcoded list of Product objects
				val products = listOf(
					Product("prod123", "Ktor Unleashed", 29.99),
					Product("prod456", "Kotlin Coroutines Guide", 19.99),
					Product("prod789", "Advanced Kotlin Programming", 39.99)
				)
				call.respond(products)
			}
		}
	}.start(wait = true)
}