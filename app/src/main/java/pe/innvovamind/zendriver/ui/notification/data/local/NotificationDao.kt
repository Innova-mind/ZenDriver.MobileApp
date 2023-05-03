package pe.innvovamind.zendriver.ui.notification.data.local

interface NotificationDao {
    fun getNotifications(): List<NotificationEntity>
    fun getNotification(id: Int): NotificationEntity
    fun insertNotification(notification: NotificationEntity)
    fun deleteNotification(notification: NotificationEntity)
    fun deleteAllNotifications()
    fun updateNotification(notification: NotificationEntity)
}