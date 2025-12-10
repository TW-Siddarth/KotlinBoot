package com.thoughtworks.bootcamp2025
const val question = "life, the universe, and everything"
const val answer = 42

val tripleQuotedString = """
    #question = "$question"
    #answer = $answer""".trimMargin("#")

fun main() {
	val values = 1..10

	val resultSet = values
		.asSequence()
		.filter {
			println("Filtered $it")
			it % 2 == 0
		}
		.map {
			println("Mapped $it")
			it * 2
		}
		.toSet()

	println(resultSet)
}