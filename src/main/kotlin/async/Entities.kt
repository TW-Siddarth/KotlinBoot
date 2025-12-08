package com.thoughtworks.bootcamp2025.async

import kotlinx.serialization.Serializable


// Data classes to represent the responses from the remote services
@Serializable
data class User(val id: String, val name: String)

@Serializable
data class Product(val id: String, val name: String, val price: Double)
