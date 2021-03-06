import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
}
group = "me.diegogliosca"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("com.natpryce:hamkrest:1.7.0.3")
    testImplementation("org.hamcrest:hamcrest-core:1.3")
    testImplementation("org.hamcrest:hamcrest-library:1.3")
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}