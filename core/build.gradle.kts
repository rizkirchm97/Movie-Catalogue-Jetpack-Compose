import dependencies.addNetworkDependencies

plugins {
    plugins.`android-base-library`
}

android {
    namespace = "com.rizkir.core"

}

dependencies {
    addNetworkDependencies()
}