import dependencies.addAndroLifeCycleDependencies
import dependencies.addAndroidComposeDependencies
import dependencies.addAndroidTestsDependencies
import dependencies.addCoreModule
import dependencies.addCoroutinesAndroidDependencies
import dependencies.addDataModule
import dependencies.addDiModule
import dependencies.addDomainModule
import dependencies.addFeatureModule
import dependencies.addHiltDependencies
import dependencies.addLeakcanaryDependencies
import dependencies.addNetworkDependencies
import dependencies.addRoomDependencies
import dependencies.addTimberDependencies

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {


    namespace = "com.rizkir.myapplication"
    compileSdk = AppConfig.compileSdkVersion

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testRunner
        vectorDrawables {
            useSupportLibrary = true
        }



    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
    }
    buildFeatures {
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

dependencies {

    addDataModule()
    addDiModule()
    addDomainModule()
    addFeatureModule()
    addCoreModule()

    addAndroidComposeDependencies()
    addAndroLifeCycleDependencies()
    addCoroutinesAndroidDependencies()
    addHiltDependencies()
    addNetworkDependencies()
//    addLeakcanaryDependencies() // Activate when need, this for monitoring used memory of the app
    addAndroidTestsDependencies()
    addRoomDependencies()
    addTimberDependencies()

}

kapt {
    correctErrorTypes = true
}