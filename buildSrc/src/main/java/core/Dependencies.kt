package core


internal object Dependencies {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val composeMaterial = "androidx.compose.material3:material3:${Versions.materialVersion}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.activityComposeVersion}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigationVersion}"
    const val composePreviewUi = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"
    const val youtubePlayer = "com.pierfrancescosoffritti.androidyoutubeplayer:core:${Versions.youtubePlayer}"

    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleVersion}"
    const val viewModelSaveState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycleVersion}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val runtimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycleVersion}"
    const val lifecycleService = "androidx.lifecycle:lifecycle-service:${Versions.lifecycleVersion}"

    val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltNavCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationComposeVersion}"
    val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
    const val hiltComp = "androidx.hilt:hilt-compiler:${Versions.hiltNavigationComposeVersion}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val rxJava3adapter = "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofitVersion}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}"
    const val okhHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3Version}"
    const val okhHttp3Interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3Version}"
    const val retrofitMock = "com.squareup.retrofit2:retrofit-mock:${Versions.mockVersion}"
    const val paging = "androidx.paging:paging-common-ktx:${Versions.paging_version}"
    const val pagingCompose = "androidx.paging:paging-compose:${Versions.paging_compose_version}"

    const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanaryVersion}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
    const val coil = "io.coil-kt:coil-compose:${Versions.coilVersion}"


    const val jUnit = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitExtVersion}"
    const val jUnitTestUi = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
    const val composeTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.composeVersion}"

    const val roomKtx = "androidx.room:room-ktx:${Versions.room_version}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room_version}"
    const val roomPaging = "androidx.room:room-paging:${Versions.room_version}"

}