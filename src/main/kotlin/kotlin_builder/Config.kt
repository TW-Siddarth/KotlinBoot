package com.thoughtworks.bootcamp2025.kotlin_builder

data class Config(
	val host: String = "localhost",
	val port: Int = 8080,
	val useTls: Boolean = false,
	val timeout: Int = 5000,
)

fun main() {
	val defaultConfig = Config(
		host = "api.example",
		port = 443,
		useTls = true
	)
	println("Default: $defaultConfig")
	val longTimeoutConfig = defaultConfig.copy(timeout = 15000)
	println("Modified: $longTimeoutConfig")
	// The original object remains unchanged
	println("Original is unchanged: $defaultConfig")

}