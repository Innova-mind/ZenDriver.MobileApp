package pe.innvovamind.zendriver.ui.message.repository

import androidx.lifecycle.MutableLiveData
import pe.innvovamind.zendriver.ui.message.data.local.MessageDao
import pe.innvovamind.zendriver.ui.message.data.model.Message
import pe.innvovamind.zendriver.ui.message.data.remote.MessageResponse
import pe.innvovamind.zendriver.ui.message.data.remote.MessageService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MessageRepository (
    private val messageService: MessageService,
    private val messageDao: MessageDao
){
    private val _messages =  MutableLiveData<List<Message>>(emptyList())
    val messages get() = _messages
    fun fetchById(id: Int) {
        val fetchById = messageService.fetchById(id)
        fetchById.enqueue( object : Callback<List<MessageResponse>> {
            override fun onResponse(
                call: Call<List<MessageResponse>>,
                response: Response<List<MessageResponse>>
            ) {
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    val messages = body.map {
                        Message(
                            id = it.id,
                            content = it.content,
                            emitter = it.emitter,
                            receiver = it.receiver
                        )
                    }
                    _messages.value = messages
                }
            }

            override fun onFailure(call: Call<List<MessageResponse>>, t: Throwable) {
                println("Error: ${t.message}")
            }
        })
    }
}