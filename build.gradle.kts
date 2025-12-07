val ktorVersion: String by project

plugins {
	kotlin("jvm") version "2.1.20"
}

group = "com.thoughtworks.bootcamp2025"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	testImplementation(kotlin("test"))
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")

	// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
	implementation("com.fasterxml.jackson.core:jackson-databind:2.20.1")

	// https://mvnrepository.com/artifact/com.fasterxml.jackson.module/jackson-module-kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.20.1")

	implementation("io.ktor:ktor-server-core:${ktorVersion}")
	implementation("io.ktor:ktor-server-netty:${ktorVersion}")
	implementation("io.ktor:ktor-server-sse:${ktorVersion}")
	implementation("io.ktor:ktor-serialization-kotlinx-json:${ktorVersion}")

	implementation("io.ktor:ktor-client-core:${ktorVersion}")
	implementation("io.ktor:ktor-client-cio:${ktorVersion}")
	implementation("io.ktor:ktor-client-content-negotiation:${ktorVersion}")

	// https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
	implementation("ch.qos.logback:logback-classic:1.5.21")
}

tasks.test {
	useJUnitPlatform()
}
kotlin {
	jvmToolchain(21)
}