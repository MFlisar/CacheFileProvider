dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
    versionCatalogs {

        val kotlin = "1.9.10"
        val gradle = "8.1.2"

        // Rest
        create("tools") {
            version("kotlin", kotlin)
            version("gradle", gradle)
        }
        create("app") {
            version("compileSdk", "34")
            version("minSdk", "21")
            version("targetSdk", "34")
        }

        create("libs") {
            // Kotlin
            library("kotlin", "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin")
        }
    }
}

// --------------
// App
// --------------

include(":library")
project(":library").projectDir = file("library")
