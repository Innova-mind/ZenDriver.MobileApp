package pe.innvovamind.zendriver.ui.message.navigation

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.innvovamind.zendriver.ui.message.screens.MessageViewModel
import pe.innvovamind.zendriver.ui.message.screens.Messages

@Composable
fun MessageNavigation() {

    val viewModelStore = remember { ViewModelStore() } // Crea el ViewModelStore
    val navController = rememberNavController()
    navController.setViewModelStore(viewModelStore) // Establece el ViewModelStore

    NavHost(navController = navController,
        startDestination = "search",
    ) {
        composable("search") {

            Messages()
        }
    }
}
