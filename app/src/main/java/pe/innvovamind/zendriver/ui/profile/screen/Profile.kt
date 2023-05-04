package pe.innvovamind.zendriver.ui.profile.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import pe.innvovamind.zendriver.R

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

@Composable
fun ImageProfile(){
    val imageUri = rememberSaveable() {
        mutableStateOf("")
    }

    val painter = rememberAsyncImagePainter(
        if (imageUri.value.isEmpty()){
            R.drawable.baseline_person_24
        }else{
            imageUri.value
        }
    )
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .padding(10.dp)
                .size(100.dp)) {
            Image(
                painter = painter, contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { },
                contentScale = ContentScale.Crop
            )
        }
        Text(text = "Henry Turrones")
        Text(text = "\nExperience as a RRHH in driving with a semi-trailer, trailer and coupled with the guarantee of safety and the driving experience that this entails.")
    }
}