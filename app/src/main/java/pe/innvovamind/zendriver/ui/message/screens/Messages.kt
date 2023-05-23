package pe.innvovamind.zendriver.ui.message.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import pe.innvovamind.zendriver.ui.message.data.model.Message
import pe.innvovamind.zendriver.ui.message.repository.MessageRepository

@Composable
fun Messages(selectMessage: (String,String) -> Unit, receiverId: Int) {
    //create a list of messages to set in iTEMsINDEXED
    val messageRepository = remember { MessageRepository() }
    val messageGeneralState by messageRepository.messagesGeneral.observeAsState(listOf())
    messageRepository.fetchById(receiverId)

//    messages.add(Message(1,"Buenos días, entiendo que necesita...","Grupo Gloria",
//        "https://i.pinimg.com/474x/28/26/de/2826de985643bc378786eb2848f0af16.jpg",
//         1,2))
//    messages.add(Message(2, "Actualmente no está dentro de los...","Jorge Molina Cruz",
//        "https://www.pngmart.com/files/15/Smiling-Business-Man-Standing-PNG-Clipart.png",
//        1,2))
//    messages.add(Message(3, "Me gustaría recibir una actualizaci...","Rafaela Quinta Vallejo",
//        "https://e7.pngegg.com/pngimages/464/111/png-clipart-valligent-business-consultant-information-technology-businesswoman-service-people.png",
//        1,2))

    LazyVerticalGrid(columns = GridCells.Fixed(1)) {

        itemsIndexed(messageGeneralState) { index, item ->
            MessageItem(
                item, index
            ) {
                selectMessage(item.emitter.toString(),item.receiver.toString())
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun MessageItem(message: Message, index: Int, selectMessage: () -> Unit) {
    Card(
        elevation = 2.dp,
        onClick = {
            selectMessage()
        },
        modifier = Modifier.padding(vertical = 6.dp, horizontal = 8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Column(
                modifier = Modifier
                    .size(70.dp)
                    .padding(8.dp)
            ) {
                AsyncImage(
                    model = message.receiverPhotoUrl,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.clip(CircleShape)
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .weight(1f)
            ) {
                Text(
                    text = message.receiverName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = message.content,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "5:3${9-index*2} PM",
                fontSize = 12.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
        }
    }
}
