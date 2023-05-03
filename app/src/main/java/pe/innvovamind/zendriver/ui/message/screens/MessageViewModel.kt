package pe.innvovamind.zendriver.ui.message.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import pe.innvovamind.zendriver.ui.message.data.remote.MessagesClient
import pe.innvovamind.zendriver.ui.message.repository.MessageRepository
import pe.innvovamind.zendriver.ui.shared.data.local.AppDatabase

class MessageViewModel(application: Application) : AndroidViewModel(application){
    private val messageClient = MessagesClient
    private val messageDao = AppDatabase.getInstance(application).messageDao()
    private val messageRepository = MessageRepository(messageClient.messageService, messageDao)

    private var _messages = messageRepository.messages
    val messages get() = _messages

    private var _id = MutableLiveData<Int>()
    val id get() = _id

    fun fetchById() {
        messageRepository.fetchById(id.value!!)
        _messages.value = messageRepository.messages.value
    }
}