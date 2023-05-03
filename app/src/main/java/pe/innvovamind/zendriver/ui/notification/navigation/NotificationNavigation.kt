package pe.innvovamind.zendriver.ui.notification.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NotificationNavigation(navController: NavHostController) {
     NavHost(navController = navController , startDestination = "notification") {
         composable("notification") {

         }
     }

}