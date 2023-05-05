package pe.innvovamind.zendriver.ui.message.data.remote

data class MessageResponse (
    val id: Int,
    val content: String,
    val emitterName: String,
    val emitterPhotoUrl: String,
    val emitter: Int,
    val receiver: Int,
)