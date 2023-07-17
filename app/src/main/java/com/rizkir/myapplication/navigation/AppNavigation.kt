package com.rizkir.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rizkir.core.utils.NavRoute

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */

@Composable
fun AppNav(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.homeMovieScreen
    ) {
        composable(NavRoute.homeMovieScreen) {
//            val viewModel: Mov
//            HomeScreen()
        }
        composable(NavRoute.detailMovieScreen) {
//            DetailScreen()
        }
    }
}