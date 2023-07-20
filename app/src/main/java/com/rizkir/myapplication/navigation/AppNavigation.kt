package com.rizkir.myapplication.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rizkir.core.utils.NavRoute
import com.rizkir.core.utils.NetworkConnectivityObserver
import com.rizkir.core.utils.NetworkObserver
import com.rizkir.detail_movie.DetailMovieRoute
import com.rizkir.home_movie.HomeMovieRoute
import com.rizkir.home_movie.HomeMovieViewModel

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */

@Composable
fun AppNav(
    navController: NavHostController = rememberNavController(),
    context: Context
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.homeMovieScreen
    ) {
        composable(NavRoute.homeMovieScreen) {
            val viewModel: HomeMovieViewModel = hiltViewModel()
            HomeMovieRoute(viewModel = viewModel) {
                navController.navigate(NavRoute.detailMovieScreen)
            }
        }
        composable(NavRoute.detailMovieScreen) {

            DetailMovieRoute(
                onRefresh = {},
                onNavigatePopBack ={navController.popBackStack()},
                context = context
            )
        }
    }
}