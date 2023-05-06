package pe.innvovamind.zendriver.ui.shared.screens

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelStore
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import pe.innvovamind.zendriver.ui.home.screen.HomeScreen
import pe.innvovamind.zendriver.ui.message.navigation.MessageNavigation
import pe.innvovamind.zendriver.ui.profile.screen.ProfileScreen
import pe.innvovamind.zendriver.ui.settings.screens.SettingsScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavigationAppBar(
) {
    val viewModelStore = remember { ViewModelStore() } // Crea el ViewModelStore
    val navController = rememberNavController()
    navController.setViewModelStore(viewModelStore) // Establece el ViewModelStore
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "ZenDriver") },
                navigationIcon = {
                    IconButton(onClick = { /* TODO: Open drawer */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = currentRoute == "home",
                    onClick = {
                        navController.navigate("home")
                    }
                )


                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Email, contentDescription = "Message") },
                    label = { Text("Message") },
                    selected = currentRoute == "message",
                    onClick = {
                        navController.navigate("message")
                    }
                )

                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
                    label = { Text("Settings") },
                    selected = currentRoute == "settings",
                    onClick = {
                        navController.navigate("settings")
                    }
                )

                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = currentRoute == "profile",
                    onClick = {
                        navController.navigate("profile")
                    }
                )
            };
        },

        content = {
            NavHost(navController, startDestination = "home") {
                composable("home") { HomeScreen() }
                composable("message") { MessageNavigation() }
                composable("settings") { SettingsScreen() }
                composable("profile") { ProfileScreen() }
            }
        },
    )
}
