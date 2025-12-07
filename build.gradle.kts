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
}

tasks.test {
	useJUnitPlatform()
}
kotlin {
	jvmToolchain(21)
}