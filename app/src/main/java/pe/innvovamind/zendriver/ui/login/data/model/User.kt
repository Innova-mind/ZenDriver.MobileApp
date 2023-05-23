package pe.innvovamind.zendriver.ui.login.data.model

data class User (
    val id: Int,
    val firstName: String,
    val lastName: String,
    val userName: String,
    val password: String,
    val phone: String,
    val role: String,
    val description: String,
    val imageUrl: String,
)