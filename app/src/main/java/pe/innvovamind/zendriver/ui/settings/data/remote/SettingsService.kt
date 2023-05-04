package pe.innvovamind.zendriver.ui.settings.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SettingsService {

    @GET("driverprofile/{id}")
    fun fetchData(@Path("id") id: String): Call<SettingsResponse>


}