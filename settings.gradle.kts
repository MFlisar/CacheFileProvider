dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
    versionCatalogs {

        val gradle = "8.1.2"

        // Rest
        create("tools") {
            version("gradle", gradle)
        }
        create("app") {
            version("compileSdk", "34")
            version("minSdk", "21")
            version("targetSdk", "34")
        }
    }
}

// --------------
// App
// --------------

include(":library")
project(":library").projectDir = file("library")
