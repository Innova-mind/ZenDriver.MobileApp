package pe.innvovamind.zendriver.ui.shared.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.innvovamind.zendriver.ui.message.navigation.MessageNavigation
import pe.innvovamind.zendriver.ui.notification.navigation.NotificationNavigation

@Composable
fun GlobalNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            // LoginScreen(navController = navController)
        }
        composable("home") {
            //HomeNavigation(navController)
        }
        composable("notification") {
            NotificationNavigation(navController)
        }
        composable("messages") {
            MessageNavigation(navController)
        }
    }
}