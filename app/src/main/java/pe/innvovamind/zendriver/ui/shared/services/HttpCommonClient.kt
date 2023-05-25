package pe.innvovamind.zendriver.ui.shared.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpCommonClient {
    const val BASE_URL = "https://webapp-innva.azurewebsites.net/swagger/v1/"

    inline fun <reified T> createService(domain: String): T {
        val retrofit = Retrofit.Builder()
            .baseUrl("$BASE_URL$domain/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(T::class.java)
    }
}