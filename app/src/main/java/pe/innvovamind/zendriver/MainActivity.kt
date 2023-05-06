package pe.innvovamind.zendriver

import  android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pe.innvovamind.zendriver.ui.login.screens.signin.SignInViewModel
import pe.innvovamind.zendriver.ui.shared.navigation.GlobalNavigation

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
                    val viewModel: SignInViewModel by viewModels()
                    GlobalNavigation(viewModel)
                }
            }
        }
    }
}







@Composable
fun SignInScreen(onSignInSuccess: () -> Unit) {
// TODO: Add sign in form and button
}





