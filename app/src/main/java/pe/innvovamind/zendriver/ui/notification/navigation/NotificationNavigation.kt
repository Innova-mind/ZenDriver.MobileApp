package pe.innvovamind.zendriver.ui.notification.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelStore
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.innvovamind.zendriver.ui.message.data.model.Message
import pe.innvovamind.zendriver.ui.message.screens.Messages

@Composable
fun NotificationNavigation() {
     val viewModelStore = remember { ViewModelStore() } // Crea el ViewModelStore
     val navController = rememberNavController()
     navController.setViewModelStore(viewModelStore) // Establece el ViewModelStore

     NavHost(navController = navController , startDestination = "notification-user") {

     }

}