package pe.innvovamind.zendriver.ui.settings.data.remote

import pe.innvovamind.zendriver.ui.shared.services.HttpCommonClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SettingsClient {
    val settingsService = HttpCommonClient.createService<SettingsService>("users")
}