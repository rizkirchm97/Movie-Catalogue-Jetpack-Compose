package plugins
import dependencies.*

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android{
    compileSdk = AppConfig.compileSdkVersion
    defaultConfig {
        minSdk = AppConfig.minSdkVersion
        testInstrumentationRunner = AppConfig.testRunner
        consumerProguardFiles("consumer-rules.pro")
        vectorDrawables{
            useSupportLibrary = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures{
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerExtensionVersion
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies{
    addDiModule()
    addDomainModule()
    addCoreModule()

    addAndroidComposeDependencies()
    addAndroLifeCycleDependencies()
    addCoroutinesAndroidDependencies()
    addCoilImageLoadingDependencies()
    addHiltDependencies()
    addAndroidTestsDependencies()
}

kapt {
    correctErrorTypes = true


}
