
import dependencies.addDataModule
import dependencies.addNetworkDependencies

plugins {
    plugins.`android-features-library`
}

android {
    namespace = "com.rizkir.home_movie"
}
dependencies {
    addNetworkDependencies()
    addDataModule()
}
