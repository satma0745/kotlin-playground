plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:31.1-jre")
}

application {
    mainClass.set("playground.AppKt")
}
