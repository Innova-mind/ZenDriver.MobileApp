package pe.innvovamind.zendriver.ui.message.data.remote

import pe.innvovamind.zendriver.ui.shared.services.HttpCommonClient

object MessageClient {
    val messageService =  HttpCommonClient.createService<MessageService>("message")
}