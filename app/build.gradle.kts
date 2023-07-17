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
import java.util.*

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("kotlin-parcelize")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
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
    addLeakcanaryDependencies()
    addAndroidTestsDependencies()


//    implementation("androidx.core:core-ktx:1.10.1")
//    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
//    implementation("androidx.activity:activity-compose:1.7.2")
//    implementation(platform("androidx.compose:compose-bom:2022.10.00"))
//    implementation("androidx.compose.ui:ui")
//    implementation("androidx.compose.ui:ui-graphics")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    implementation("androidx.compose.material3:material3")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation(platform("androidx.compose:compose-bom:2022.10.00"))
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//    debugImplementation("androidx.compose.ui:ui-tooling")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

kapt {
    correctErrorTypes = true
}