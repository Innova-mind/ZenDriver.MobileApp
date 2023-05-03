package pe.innvovamind.zendriver.ui.message.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MessageService {
    @GET("search-by-id/{id}")
    fun fetchById(@Path("id") name: String): Call<MessageResponse>

}