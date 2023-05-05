package pe.innvovamind.zendriver.ui.message.data.model

data class Message(
    val id: Int,
    val content: String,
    val emitterName: String,
    val emitterPhotoUrl: String,
    val emitter: Int,
    val receiver: Int,
)
