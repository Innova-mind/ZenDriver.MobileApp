package pe.innvovamind.zendriver.ui.message.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import pe.innvovamind.zendriver.ui.message.data.model.Message
import pe.innvovamind.zendriver.ui.message.repository.MessageRepository

@Composable
fun Messages() {
    //create a list of messages to set in iTEMsINDEXED
    var messages : MutableList<Message>  = mutableListOf()
    messages.add(Message(1, "Hola", "Nicole","Camila"))
    messages.add(Message(2, "Hola", "Nicole","Camila"))
    messages.add(Message(3, "Hola", "Nicole","Camila"))

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {

        itemsIndexed(messages) { index, item ->
            MessageItem(
                item, index
            ) {
                //selectMessage("${index + 1}")
            }
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
        }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/message/${index + 1}.png",
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Text(text = message.content)
        }
    }
}
