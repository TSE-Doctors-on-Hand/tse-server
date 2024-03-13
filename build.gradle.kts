plugins {
    kotlin("jvm") version "1.9.20"
    application
}

group = "org.tse"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.jan-tennert.supabase:postgrest-kt:2.2.1")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}