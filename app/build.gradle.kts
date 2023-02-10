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

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest("1.7.10")

            dependencies {
                implementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
            }
        }
    }
}

application {
    mainClass.set("playground.AppKt")
}
