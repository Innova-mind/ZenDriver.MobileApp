package pe.innvovamind.zendriver.ui.message.data.local

import androidx.room.Dao
import androidx.room.Query

@Dao
interface MessageDao {
    @Query("SELECT * FROM message")
    fun getMessages(): List<MessageEntity>
    @Query("SELECT * FROM message WHERE id = :id")
    fun getMessage(id: Int): MessageEntity
    fun addMessage(message: MessageEntity)
    fun updateMessage(message: MessageEntity)
    fun deleteMessage(message: MessageEntity)
}