package com.rizkir.myapplication.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rizkir.core.utils.NavRoute
import com.rizkir.core.utils.NetworkConnectivityObserver
import com.rizkir.core.utils.NetworkObserver
import com.rizkir.detail_movie.DetailMovieRoute
import com.rizkir.detail_movie.DetailMovieViewModel
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
            HomeMovieRoute(viewModel = viewModel) { id ->
                navController.navigate(NavRoute.detailMovieScreen + "/$id")
            }
        }
        composable(route = "${NavRoute.detailMovieScreen}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType})
            ) { backStack ->
            val viewModel: DetailMovieViewModel = hiltViewModel()
            val param = backStack.arguments?.getInt("id") ?: 0
            DetailMovieRoute(
                viewModel = viewModel,
                onRefresh = {},
                movieId = param,
                onNavigatePopBack ={navController.popBackStack()},
                context = context
            )
        }
    }
}