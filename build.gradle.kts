defaultTasks(
    ":api:build",
    ":api:test"
)
java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

plugins {
    kotlin("jvm") version "1.4.10"
}

allprojects {
    repositories {
        mavenCentral()
    }
    apply(plugin = "kotlin")

    tasks {
        compileKotlin {
            kotlinOptions.jvmTarget = "11"
        }
    }
}
