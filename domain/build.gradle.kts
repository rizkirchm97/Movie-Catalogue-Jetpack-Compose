import dependencies.addCoreModule

plugins {
    plugins.`android-core-library`
}

android {
    namespace = "com.rizkir.domain"

}

dependencies {
    addCoreModule()
}