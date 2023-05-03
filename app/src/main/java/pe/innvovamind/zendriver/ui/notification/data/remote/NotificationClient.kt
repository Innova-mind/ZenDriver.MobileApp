package pe.innvovamind.zendriver.ui.notification.data.remote

import pe.innvovamind.zendriver.ui.shared.services.HttpCommonClient

object NotificationClient {
    val notificationService =  HttpCommonClient.createService<NotificationService>("notification")
}