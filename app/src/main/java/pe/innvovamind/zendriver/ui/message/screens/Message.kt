package pe.innvovamind.zendriver.ui.message.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import pe.innvovamind.zendriver.ui.message.repository.MessageRepository

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MessageDetail(onBack: () -> Boolean, emitterId: Int, receiverId: Int) {
    val messageRepository = remember { MessageRepository() }
    val messageState by messageRepository.messages.observeAsState(listOf())
    messageRepository.getMessagesByEmmiterAndReceiver(emitterId, receiverId)

    var messageToSend by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        BackButton(onClick = {
            onBack()
        })
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
        ) {
            itemsIndexed(messageState) { index, message ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = 2.dp,
                    backgroundColor = if (message.receiverId   == 2) Color(0xFF1e81b0) else Color.White,
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
        Column(modifier = Modifier.fillMaxWidth()) {
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    modifier = Modifier.weight(1f),
                    value = messageToSend,
                    onValueChange = { messageToSend = it },
                    textStyle = MaterialTheme.typography.body1,
                    placeholder = { Text(text = "Send a message...") },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        cursorColor = MaterialTheme.colors.primary
                    ),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Send,
                        keyboardType = KeyboardType.Text
                    ),
                    keyboardActions = KeyboardActions(
                        onSend = {
                            sendMessage(messageToSend)
                            messageToSend = ""
                        }
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    onClick = {
                        sendMessage(messageToSend)
                        messageToSend = ""
                    },
                    enabled = messageToSend.isNotBlank()
                ) {
                    Icon(
                        imageVector = Icons.Default.Send,
                        contentDescription = "Send"
                    )
                }
            }
        }
    }
}

private fun sendMessage(
    message: String
) {
    if (message.isNotBlank()) {
//        messageList.add(MessageResponse(
//            messageList.size + 1,
//            message,
//            "",
//            "",
//            1,
//            2
//        ))
    }
}
@Composable
fun BackButton(onClick: () -> Unit) {
    IconButton(onClick = onClick, modifier = Modifier.padding(8.dp)) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
    }
}

