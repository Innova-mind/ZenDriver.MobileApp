package pe.innvovamind.zendriver.ui.shared.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelStore
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.innvovamind.zendriver.ui.message.navigation.MessageNavigation
import pe.innvovamind.zendriver.ui.notification.navigation.NotificationNavigation

@Composable
fun GlobalNavigation() {
    val viewModelStore = remember { ViewModelStore() }
    val navController = rememberNavController()
    navController.setViewModelStore(viewModelStore)
    NavHost(navController = navController, startDestination = "messages") {
//    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            // LoginScreen()
        }
        composable("home") {
            //HomeNavigation()
        }
        composable("notification") {
            //NotificationNavigation()
        }
        composable("messages") {
            MessageNavigation()
        }
    }
}