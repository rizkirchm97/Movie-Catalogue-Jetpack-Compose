package dependencies

import core.*

internal val featureModule = listOf(
    ModulesDep.detail_movie,
    ModulesDep.home_movie,
)

internal val dataModule = listOf(
    ModulesDep.model,
    ModulesDep.local,
    ModulesDep.remote
)

internal val coreModule = listOf(
    ModulesDep.component,
    ModulesDep.providers,
    ModulesDep.themes
)