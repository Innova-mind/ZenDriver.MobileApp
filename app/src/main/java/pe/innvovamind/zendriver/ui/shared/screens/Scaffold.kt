package pe.innvovamind.zendriver.ui.shared.screens

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pe.innvovamind.zendriver.ui.home.screen.HomeScreen
import pe.innvovamind.zendriver.ui.message.navigation.MessageNavigation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomMenu() {
    val materialBlue700= Color(0xFF1976D2)
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = {Text("TopAppBar")},backgroundColor = materialBlue700)  },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = {}){
            Text("X")
        } },
        content = { MessageNavigation() },
        bottomBar = { BottomAppBar(backgroundColor = materialBlue700) { Text("BottomAppBar") } }
    )

}