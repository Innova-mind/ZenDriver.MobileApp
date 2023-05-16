package pe.innvovamind.zendriver.ui.shared.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelStore
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.innvovamind.zendriver.ui.login.screens.signin.SignInScreen
import pe.innvovamind.zendriver.ui.login.screens.signin.SignInViewModel
import pe.innvovamind.zendriver.ui.shared.screens.NavigationAppBar

@Composable
fun GlobalNavigation(viewModel: SignInViewModel) {
    val viewModelStore = remember { ViewModelStore() }
    val navController = rememberNavController()
    navController.setViewModelStore(viewModelStore)
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {

            SignInScreen(viewModel = viewModel, onSignInSuccess = { navController.navigate("navigation") })
        }
        composable("navigation") {
            NavigationAppBar()
        }

    }
}