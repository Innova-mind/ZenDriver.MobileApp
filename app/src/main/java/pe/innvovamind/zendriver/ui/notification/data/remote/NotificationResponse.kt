package pe.innvovamind.zendriver.ui.notification.data.remote

import java.sql.Date

data class NotificationResponse (
    val id: String,
    val content: String,
    val date: Date,
    val emitter: String,
    val receiver: String,
)