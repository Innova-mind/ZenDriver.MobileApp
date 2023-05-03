package pe.innvovamind.zendriver.ui.message.data.remote

data class MessageResponse (
    val id: String,
    val content: String,
    val emitter: String,
    val receiver: String,
)