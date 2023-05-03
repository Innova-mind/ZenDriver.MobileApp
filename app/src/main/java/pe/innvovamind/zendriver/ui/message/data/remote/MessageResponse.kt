package pe.innvovamind.zendriver.ui.message.data.remote

data class MessageResponse (
    val id: Int,
    val content: String,
    val emitter: String,
    val receiver: String,
)