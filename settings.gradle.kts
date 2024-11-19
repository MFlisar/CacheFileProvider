pluginManagement {

    // repositories for build
    repositories {
        mavenCentral()
        google()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
    versionCatalogs {
        create("app") {
            from(files("gradle/app.versions.toml"))
        }
        create("androidx") {
            from(files("gradle/androidx.versions.toml"))
        }
    }
}

// --------------
// Library
// --------------

include(":library")
project(":library").projectDir = file("library")
