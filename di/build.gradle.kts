import dependencies.addTimberDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    plugins.`android-core-library`
}

android {
    namespace = "com.rizkir.di"

}

dependencies {
    addTimberDependencies()
}