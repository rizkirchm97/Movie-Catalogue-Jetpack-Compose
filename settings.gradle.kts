@file:Suppress("UnstableApiUsage")
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        google()
        gradlePluginPortal()
        maven("https://jitpack.io")
        maven("https://oss.jfrog.org/libs-snapshot")
    }

    gradle.projectsLoaded {
        plugins {
            plugins {
                id("com.android.application") version (extra.properties["androidGradlePluginVersion"].toString())
                id("com.android.library") version (extra.properties["androidGradlePluginVersion"].toString())
                id("org.jetbrains.kotlin.android") version (extra.properties["kotlinVersion"].toString())
                id("org.jetbrains.kotlin.jvm") version (extra.properties["kotlinVersion"].toString())
                id("org.jetbrains.kotlin.plugin.parcelize") version (extra.properties["kotlinVersion"].toString())
                kotlin("kapt") version (extra.properties["1.9.0"].toString())
                id("com.google.dagger.hilt.android") version (extra.properties["hiltVersion"].toString())
            }
        }


    }
}



dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        google()
        maven("https://jitpack.io")
        maven("https://oss.jfrog.org/libs-snapshot")
    }
}
rootProject.name = "Movie Catalogue"
include(":core")
include(":data")
include(":app")
include(":domain")
include(":features:home_movie")
include(":features:detail_movie")
include(":di")
