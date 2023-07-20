import dependencies.addNetworkDependencies

plugins {
    plugins.`android-base-library`
}

android {
    namespace = "com.rizkir.core"

}

dependencies {
    addNetworkDependencies()
    implementation("com.pierfrancescosoffritti.androidyoutubeplayer:core:12.0.0")
}