package pe.innvovamind.zendriver.ui.settings.screens

import pe.innvovamind.zendriver.ui.settings.data.model.Driver


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage



@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {

    var user = remember {
        mutableStateOf<Driver?>(null)
    }


    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp), horizontalArrangement = Arrangement.Center
        ) {
            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp), elevation = 20.dp) {
                Column() {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Text(text = "Configuración", fontSize = 30.sp)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        SettingsImage()
                    }
                }


            }
        }


        user.value?.let { user ->
            SettingsInformation(user)
        }

    }
}

@Composable
fun SettingsImage(modifier: Modifier = Modifier) {

    AsyncImage(
        model = "https://static.vecteezy.com/system/resources/previews/007/296/443/original/user-icon-person-icon-client-symbol-profile-icon-vector.jpg",
        contentDescription = null,
        modifier = Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(50.dp)),
    )

}

@Composable
fun SettingsInformation(user: Driver, modifier: Modifier = Modifier) {
    var UserTest = user

    val user_change = remember {
        mutableStateOf(user)
    }
    val new_values = user
    Card(
        modifier = Modifier
            .padding(16.dp)

    , elevation = 20.dp) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White)
        ) {
            Text(text = "Nombre completo", fontSize = 20.sp)
            Spacer(modifier = Modifier.size(10.dp))
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .border(3.dp, Color.Black, RoundedCornerShape(14.dp))
                    .fillMaxWidth()
                    .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

            ) {
                val isEditing = remember { mutableStateOf(false) }
                if (isEditing.value) {
                    TextField(
                        value = user_change.value.FirstName,
                        onValueChange = { user_change.value = user_change.value.copy(FirstName = it) },

                        )
                } else {
                    Text(user_change.value.FirstName)
                }
                IconButton(onClick = { isEditing.value = !isEditing.value }) {
                    if (isEditing.value) {
                        Icon(Icons.Filled.Close, null)
                    }else{
                       Icon(Icons.Filled.Edit, null)
                    }
                }
            }
            Spacer(modifier = Modifier.size(10.dp))

            Text(text = "Teléfono", fontSize = 20.sp)
            Spacer(modifier = Modifier.size(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .border(3.dp, Color.Black, RoundedCornerShape(14.dp))
                    .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {

                val isEditing = remember { mutableStateOf(false) }
                if (isEditing.value) {
                    TextField(
                        value = user_change.value.Phone,
                        onValueChange = { user_change.value = user_change.value.copy(Phone = it) },
                    )
                } else {
                    Text(user_change.value.Phone)
                }
                IconButton(onClick = { isEditing.value = !isEditing.value }) {
                    if (isEditing.value) {
                        Icon(Icons.Filled.Close, null)
                    }else{
                        Icon(Icons.Filled.Edit, null)
                    }
                }

            }
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "Correo electrónico", fontSize = 20.sp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .border(3.dp, Color.Black, RoundedCornerShape(14.dp))
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                val isEditing = remember { mutableStateOf(false) }
                if (isEditing.value) {
                    TextField(
                        value = user_change.value.Email,
                        onValueChange = { user_change.value = user_change.value.copy(Email = it) },
                    )
                } else {
                    Text(user_change.value.Email)
                }
                IconButton(onClick = { isEditing.value = !isEditing.value }) {
                    if (isEditing.value) {
                        Icon(Icons.Filled.Close, null)
                    }else{
                        Icon(Icons.Filled.Edit, null)
                    }
                }

            }
            Text(text = "Contraseña", fontSize = 20.sp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .border(3.dp, Color.Black, RoundedCornerShape(14.dp))
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                val isEditing = remember { mutableStateOf(false) }
                if (isEditing.value) {
                    TextField(
                        value = user_change.value.Password,
                        onValueChange = {
                            user_change.value = user_change.value.copy(Password = it)
                        },
                        visualTransformation = PasswordVisualTransformation()
                    )
                } else {
                    TextField(
                        value = user_change.value.Password,
                        onValueChange = {},
                        readOnly = true,
                        visualTransformation = PasswordVisualTransformation()
                    )
                }
                IconButton(onClick = { isEditing.value = !isEditing.value }) {
                    if (isEditing.value) {
                        Icon(Icons.Filled.Close, null)
                    }else{
                        Icon(Icons.Filled.Edit, null)
                    }
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Button(onClick = {
                    //create an alert

                    UserTest = user_change.value
                }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0,150,136), contentColor = Color.White),
                    modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)) {
                    Text(text = "Guardar")
                }
                Button(onClick = { /*TODO*/ }
                    , colors = ButtonDefaults.buttonColors(backgroundColor = Color(0,150,136), contentColor = Color.White),
                    modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)
                ) {
                    Text(text = "Cancelar")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSettings() {
    SettingsScreen()
}