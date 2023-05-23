package pe.innvovamind.zendriver.ui.message.data.remote

import pe.innvovamind.zendriver.ui.login.data.model.User
import java.util.Date

data class MessageResponse (
    val id: Int,
    val content: String,
    val receiverName: String,
    val receiverPhotoUrl: String,
    val emitter: User,
    val emitterId: Int,
    val receiver: User,
    val receiverId: Int,
    val createdAt: Date,
)