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

    addDiModule()
    addDomainModule()
    addCoreModule()
    addTimberDependencies()
}