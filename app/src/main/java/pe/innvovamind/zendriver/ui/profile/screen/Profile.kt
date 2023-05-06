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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
        }
            ImageProfile()
            ProfileInformation()

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


@Composable
fun ProfileInformation(){
    var email by rememberSaveable {
        mutableStateOf("henry.antonio@gmail.com")
    }
    var phone by rememberSaveable {
        mutableStateOf("(+51) 983 543 439")
    }
    var address by rememberSaveable {
        mutableStateOf("Lima, Lince")
    }
    var facebook by rememberSaveable {
        mutableStateOf("@Maconsa")
    }
    var instagram by rememberSaveable {
        mutableStateOf("@Maconsa")
    }
    var twitter by rememberSaveable {
        mutableStateOf("@Maconsa")
    }


    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 4.dp, end = 4.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Email", modifier = Modifier.width(100.dp))
        TextField(value = email, onValueChange = {email = it} )
    }
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 4.dp, end = 4.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Phone", modifier = Modifier.width(100.dp))
        TextField(value = phone, onValueChange = {phone = it} )
    }
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 4.dp, end = 4.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Address", modifier = Modifier.width(100.dp))
        TextField(value = address, onValueChange = {address = it} )
    }
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 4.dp, end = 4.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Facebook", modifier = Modifier.width(100.dp))
        TextField(value = facebook, onValueChange = {instagram = it} )
    }
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 4.dp, end = 4.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Instagram", modifier = Modifier.width(100.dp))
        TextField(value = instagram, onValueChange = {instagram = it} )
    }
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 4.dp, end = 4.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Twitter", modifier = Modifier.width(100.dp))
        TextField(value = twitter, onValueChange = {twitter = it} )
    }
}