package dependencies

import core.*
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

fun DependencyHandler.addDiModule(configurationName: String = "implementation") {
    add(configurationName, project(ModulesDep.di))
}

fun DependencyHandler.addDomainModule() {
    add("implementation", project(ModulesDep.domain))
}

fun DependencyHandler.addDataModule() {
    add("implementation", project(ModulesDep.data))

}

fun DependencyHandler.addCoreModule() {

    add("implementation", project(ModulesDep.core))


}

fun DependencyHandler.addFeatureModule() {
    featureModule.forEach {
        add("implementation", project(it))
    }
}