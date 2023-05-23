package pe.innvovamind.zendriver.ui.message.repository

import androidx.lifecycle.MutableLiveData
import pe.innvovamind.zendriver.ui.message.data.local.MessageDao
import pe.innvovamind.zendriver.ui.message.data.model.Message
import pe.innvovamind.zendriver.ui.message.data.remote.MessageResponse
import pe.innvovamind.zendriver.ui.message.data.remote.MessageService
import pe.innvovamind.zendriver.ui.message.data.remote.MessagesClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.sql.Date

class MessageRepository (
){
    private val messageService = MessagesClient.messageService
    private val _messages =  MutableLiveData<List<Message>>(emptyList())
    private val _messagesGeneral =  MutableLiveData<List<Message>>(emptyList())
    val messages get() = _messages
    val messagesGeneral get() = _messagesGeneral
    fun fetchById(id: Int) {
        val fetchById = messageService.fetchById(id)
        fetchById.enqueue( object : Callback<List<MessageResponse>> {
            override fun onResponse(
                call: Call<List<MessageResponse>>,
                response: Response<List<MessageResponse>>
            ) {
                val body = response.body()
                println("FetchById: ${response.body()}")
                if (response.isSuccessful && body != null) {
                    val messages = body.map {
                        Message(
                            id = it.id,
                            content = it.content,
                            emitter = it.emitter,
                            emitterId = it.emitter.id,
                            receiver = it.receiver,
                            receiverId = it.receiver.id,
                            receiverName = it.receiver.firstName+" "+it.receiver.lastName,
                            receiverPhotoUrl = it.receiver.imageUrl,
                            createdAt = it.createdAt as Date
                        )
                    }
                    _messagesGeneral.value = messages
                }
            }

            override fun onFailure(call: Call<List<MessageResponse>>, t: Throwable) {
                println("Error: ${t.message}")
            }
        })
    }
    fun getMessagesByEmmiterAndReceiver(emitterId: Int, receiverId: Int) {
        val getMessage = messageService.getMessage(emitterId,receiverId)
        getMessage.enqueue(object : Callback<List<MessageResponse>>
        {
            override fun onResponse(
                call: Call<List<MessageResponse>>,
                response: Response<List<MessageResponse>>
            ) {
                val messageResponse = response.body()?.get(0)
                if (messageResponse != null) {
                    val message = response.body()!!.map {
                        Message(
                            id = it.id,
                            content = it.content,
                            emitter = it.emitter,
                            emitterId = it.emitter.id,
                            receiver = it.receiver,
                            receiverId = it.receiver.id,
                            receiverName = it.receiver.firstName+" "+it.receiver.lastName,
                            receiverPhotoUrl = it.receiver.imageUrl,
                            createdAt = it.createdAt as Date
                        )
                    }
                    _messages.value = message
                }
            }

            override fun onFailure(call: Call<List<MessageResponse>>, t: Throwable) {
                println("Error")
            }
        })
    }

}