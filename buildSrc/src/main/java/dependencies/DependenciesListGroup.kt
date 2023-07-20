package dependencies
import core.Dependencies

internal val androidComposeDependencies = listOf(
    Dependencies.coreKtx,
    Dependencies.composeMaterial,
    Dependencies.composeActivity,
    Dependencies.composeUi,
    Dependencies.composePreviewUi,
    Dependencies.composeNavigation,
    Dependencies.fragment,
    Dependencies.youtubePlayer
)

internal val androidxLifeCycleDependencies = listOf(
    Dependencies.viewModel,
    Dependencies.liveData,
    Dependencies.runtimeCompose,
    Dependencies.viewModelSaveState,
    Dependencies.lifecycleService,
)

internal val coroutinesAndroidDependencies = listOf(
    Dependencies.kotlinCoroutines,
)

internal val coilImageLoadingDependencies = listOf(
    Dependencies.coil,
)

internal val networkDependencies = listOf(
    Dependencies.retrofit,
    Dependencies.moshiConverter,
    Dependencies.retrofitMock,
    Dependencies.okhHttp3,
    Dependencies.okhHttp3Interceptor,
    Dependencies.rxJava3adapter,
    Dependencies.pagingCompose,
    Dependencies.paging
)