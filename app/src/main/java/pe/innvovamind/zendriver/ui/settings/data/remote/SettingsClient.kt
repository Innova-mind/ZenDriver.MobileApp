package pe.innvovamind.zendriver.ui.settings.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SettingsClient {
    private const val BASE_URL = "https://localhost:4500/api/v1/"
    fun settingsService(): SettingsService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(SettingsService::class.java)
    }
}