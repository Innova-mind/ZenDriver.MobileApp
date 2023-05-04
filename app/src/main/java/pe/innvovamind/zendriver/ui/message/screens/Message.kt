package pe.innvovamind.zendriver.ui.message.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pe.innvovamind.zendriver.ui.message.data.remote.MessageResponse

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MessageDetail(messageList: SnapshotStateList<MessageResponse>, onBack: () -> Boolean) {

    messageList.add(MessageResponse(1,
        "Tenga buen día, al usar la aplicación, me he dado cuenta que usted cumple " +
                "los requisitos que necesito. ¿Estaría de acuerdo en trabajar para el Grupo " +
                "Gloria?","","",1,2))
    messageList.add(MessageResponse(2,
        "Buenos días, entiendo que necesita un conductor con experiencia en el manejo de " +
                "camiones de carga pesada, con licencia AIIIB. Actualmente no está dentro de los " +
                "planes de la empresa contratar a un nuevo conductor, pero si usted está " +
                "interesado, podemos hacer una excepción.","","",2,1))
    messageList.add(MessageResponse(3,
        "Me gustaría recibir una actualización de su situación actual, para poder " +
                "considerarlo en un futuro.","","",1,2))

    Column(modifier = Modifier.fillMaxSize()) {
        BackButton(onClick = {
            onBack()
        })
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
        ) {
            itemsIndexed(messageList) { index, message ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = 2.dp,
                    //border = if (message.receiver == 2) BorderStroke(2.dp, Color.Red, RoundedCornerShape(0.dp, 8.dp, 8.dp, 0.dp)) else null,
                    backgroundColor = if (message.receiver == 2) Color(0xFF1e81b0) else Color.White,
                    onClick = {
                        // hacer algo al hacer clic en la tarjeta
                    }
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = message.content,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }


}

@Composable
fun BackButton(onClick: () -> Unit) {
    IconButton(onClick = onClick, modifier = Modifier.padding(8.dp)) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
    }
}

