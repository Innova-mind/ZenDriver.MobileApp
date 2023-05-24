package pe.innvovamind.zendriver.ui.settings.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SettingsService {

    @GET("/{id}")
    fun fetchUserData(@Path("id") id: Int): Call<SettingsResponse>

}