package pe.innvovamind.zendriver.ui.settings.screens

import android.util.Log
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import pe.innvovamind.zendriver.ui.settings.data.remote.SettingsClient
import pe.innvovamind.zendriver.ui.settings.data.remote.SettingsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun Settings(modifier: Modifier = Modifier) {
    val user = remember {
        mutableStateOf<Driver>(Driver("Test", "d@gmail.com", "dawdwadaw", "34858878"))
    }
    val settingService = SettingsClient.settingsService()
    val fetchData = settingService.fetchData("1")

    fetchData.enqueue(object : Callback<SettingsResponse> {
        override fun onResponse(
            call: Call<SettingsResponse>,
            response: Response<SettingsResponse>
        ) {
            if (response.isSuccessful) {
                user.value = response.body()!!.result
                Log.d("Settings", "Success: ${response.body()!!.result}")
            }
        }

        override fun onFailure(call: Call<SettingsResponse>, t: Throwable) {
            Log.d("Settings", "Error: ${t.message}")
        }
    })


    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp), horizontalArrangement = Arrangement.Center
        ) {

            Text(text = "Settings", fontSize = 30.sp)
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            SettingsImage()
        }
        SettingsInformation(user.value)
    }
}

@Composable
fun SettingsImage(modifier: Modifier = Modifier) {

    AsyncImage(
        model = "https://static.vecteezy.com/system/resources/previews/007/296/443/original/user-icon-person-icon-client-symbol-profile-icon-vector.jpg",
        contentDescription = null,
        modifier = Modifier.size(100.dp)
    )

}

@Composable
fun SettingsInformation(user: Driver, modifier: Modifier = Modifier) {
    var UserTest = user

    val user_change = remember {
        mutableStateOf(user)
    }
    val new_values = user
    Card(modifier = Modifier.background(Color.Cyan).padding(16.dp).clip(RoundedCornerShape(16.dp))) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Full Name", fontSize = 16.sp)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val isEditing = remember { mutableStateOf(false) }
                if (isEditing.value) {
                    TextField(
                        value = user_change.value.Fname,
                        onValueChange = { user_change.value = user_change.value.copy(Fname = it) },
                    )
                } else {
                    Text(user_change.value.Fname)
                }
                IconButton(onClick = { isEditing.value = !isEditing.value }) {
                    Icon(Icons.Filled.Edit, null)
                }
            }

            Text(text = "Phone", fontSize = 16.sp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween
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
                    Icon(Icons.Filled.Edit, null)
                }

            }
            Text(text = "Email", fontSize = 16.sp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
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
                    Icon(Icons.Filled.Edit, null)
                }

            }
            Text(text = "Password", fontSize = 16.sp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val isEditing = remember { mutableStateOf(false) }
                if (isEditing.value) {
                    TextField(
                        value = user_change.value.Password,
                        onValueChange = { user_change.value = user_change.value.copy(Password = it) },
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
                    Icon(Icons.Filled.Edit, null)
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Button(onClick = {
                    UserTest = user_change.value
                }, modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)) {
                    Text(text = "save")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "cancel")
                }
            }
        }
    }
}
