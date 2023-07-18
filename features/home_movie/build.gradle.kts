import dependencies.addNetworkDependencies

plugins {
    plugins.`android-features-library`
}

android {
    namespace = "com.rizkir.home_movie"
}
dependencies {
    implementation("androidx.paging:paging-common-ktx:3.1.1")
    addNetworkDependencies()
}
