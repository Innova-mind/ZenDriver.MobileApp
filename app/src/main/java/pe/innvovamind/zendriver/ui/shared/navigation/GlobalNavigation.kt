package pe.innvovamind.zendriver.ui.shared.navigation

import android.provider.ContactsContract
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelStore
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import pe.innvovamind.zendriver.ui.home.screen.HomeScreen
import pe.innvovamind.zendriver.ui.login.screens.signin.SignInScreen
import pe.innvovamind.zendriver.ui.login.screens.signin.SignInViewModel
import pe.innvovamind.zendriver.ui.message.navigation.MessageNavigation
import pe.innvovamind.zendriver.ui.profile.screen.ProfileScreen
import pe.innvovamind.zendriver.ui.settings.screens.SettingsScreen
import pe.innvovamind.zendriver.ui.shared.screens.NavigationAppBar

@Composable
fun GlobalNavigation(viewModel: SignInViewModel) {
    val viewModelStore = remember { ViewModelStore() }
    val navController = rememberNavController()
    navController.setViewModelStore(viewModelStore)
    NavHost(navController = navController, startDestination = "navigation") {
        composable("login") {

            SignInScreen(viewModel = viewModel, onSignInSuccess = { navController.navigate("navigation") })
        }
        composable("navigation") {
            NavigationAppBar()
        }

    }
}