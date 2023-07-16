import dependencies.addTimberDependencies

plugins {
    plugins.`android-core-library`
}

android {
    namespace = "com.rizkir.di"

}

dependencies {
    addTimberDependencies()
}