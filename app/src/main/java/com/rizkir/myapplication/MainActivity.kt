package com.rizkir.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.rizkir.core.utils.NetworkConnectivityObserver
import com.rizkir.core.utils.NetworkObserver
import com.rizkir.detail_movie.DetailMovieContentView
import com.rizkir.myapplication.navigation.AppNav
import com.rizkir.myapplication.ui.theme.MovieCatalogueTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieCatalogueTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                val networkObserver: NetworkObserver = NetworkConnectivityObserver(applicationContext)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNav(navController = navController, applicationContext)
                }
            }
        }
    }
}

