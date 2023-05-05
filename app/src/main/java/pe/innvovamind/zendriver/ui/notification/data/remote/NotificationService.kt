package pe.innvovamind.zendriver.ui.notification.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NotificationService {
    @GET("search-by-id/{id}")
    fun fetchById(@Path("id") name: String): Call<NotificationResponse>

}