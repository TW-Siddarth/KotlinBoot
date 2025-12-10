package com.thoughtworks.bootcamp2025.kotlin_when

sealed interface Event
class LoginEvent(val username: String): Event
object LogoutEvent: Event
class MessageEvent(val message: String): Event

fun logEvent(event: Event) = when(event) {
	is LoginEvent -> "Logged in ${event.username}"
	LogoutEvent -> "Logged out"
	is MessageEvent -> "Message: ${event.message}"
}