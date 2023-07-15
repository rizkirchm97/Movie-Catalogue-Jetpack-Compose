import dependencies.addDiModule
import dependencies.addDomainModule

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    plugins.`android-core-library`
}

android {
    namespace = "com.rizkir.remote"

}

dependencies {
    addDiModule()
    addDomainModule()
}