package pe.innvovamind.zendriver.ui.message.data.model

data class Message(
    val id: Int,
    val content: String,
    val emitter: String,
    val receiver: String,
)
