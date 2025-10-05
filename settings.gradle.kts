pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("com.android.application") version "8.5.2"        // AGP (ajústalo si tu proyecto usa otra)
        id("org.jetbrains.kotlin.android") version "2.0.0"    // Kotlin
        id("org.jetbrains.kotlin.plugin.compose") version "2.0.0" // Compose Compiler plugin
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TwoScreens"
include(":app")
