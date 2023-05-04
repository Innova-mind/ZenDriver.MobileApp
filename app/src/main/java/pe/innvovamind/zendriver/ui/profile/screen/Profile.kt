package pe.innvovamind.zendriver.ui.profile.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(modifier: Modifier = Modifier){
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(8.dp)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "☰")
        }
        Card(modifier = Modifier.fillMaxSize().padding(4.dp)

        ) {
            ImageProfile()
            ProfileInformation()
        }

    }


}