import dependencies.addDiModule
import dependencies.addDomainModule

plugins {
    plugins.`android-core-library`
}

android {
    namespace = "com.rizkir.data"

}

dependencies {
    addDiModule()
    addDomainModule()
}