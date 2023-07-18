import dependencies.addCoreModule
import dependencies.addDiModule
import dependencies.addDomainModule
import dependencies.addTimberDependencies

plugins {
    plugins.`android-core-library`
}

android {
    namespace = "com.rizkir.data"

}

dependencies {
    implementation("androidx.paging:paging-common-ktx:3.1.1")
    addDiModule()
    addDomainModule()
    addCoreModule()
    addTimberDependencies()
}