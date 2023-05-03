package pe.innvovamind.zendriver.ui.message.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MessageNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "messages") {
        composable("messages") {

        }
    }
}