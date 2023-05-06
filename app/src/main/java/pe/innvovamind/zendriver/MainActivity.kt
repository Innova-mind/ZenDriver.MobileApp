package pe.innvovamind.zendriver

import android.annotation.SuppressLint
import  android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import pe.innvovamind.zendriver.ui.message.navigation.MessageNavigation
import pe.innvovamind.zendriver.ui.home.screen.HomeScreen
import pe.innvovamind.zendriver.ui.message.screens.Messages
import pe.innvovamind.zendriver.ui.settings.screens.Settings
import pe.innvovamind.zendriver.ui.profile.screen.ProfileScreen
import pe.innvovamind.zendriver.ui.login.screens.signin.SignInScreen

import pe.innvovamind.zendriver.ui.theme.ZenDriverTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZenDriverTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavigationAppBar(navController = navController)
                }
            }
        }
    }
}






@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavigationAppBar(navController: NavHostController) {
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
                        navController.navigate("home") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                )

                /*BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Notifications, contentDescription = "Notification") },
                    label = { Text("Notifications") },
                    selected = currentRoute == "notifications",
                    onClick = {
                        navController.navigate("notifications") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                )*/

                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Email, contentDescription = "Message") },
                    label = { Text("Message") },
                    selected = currentRoute == "message",
                    onClick = {
                        navController.navigate("message") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                )

                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
                    label = { Text("Settings") },
                    selected = currentRoute == "settings",
                    onClick = {
                        navController.navigate("settings") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                )

                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = currentRoute == "profile",
                    onClick = {
                        navController.navigate("profile") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                )
            };
        }
    ) {
        NavHost(navController, startDestination = "home") {
            composable("home") { HomeScreen()}
            composable("message") {
                Messages(selectMessage = { message, sender ->
                    println("Mensaje seleccionado: $message, enviado por $sender")
                })
            }
            composable("settings") { Settings() }
            composable("profile") { ProfileScreen() }
        }
    }
}

@Composable
fun SignInScreen(onSignInSuccess: () -> Unit) {
// TODO: Add sign in form and button
}





