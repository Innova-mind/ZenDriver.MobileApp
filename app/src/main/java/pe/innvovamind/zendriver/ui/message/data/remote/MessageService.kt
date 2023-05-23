package pe.innvovamind.zendriver.ui.message.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MessageService {
    @GET("search-by-id/{id}")
    fun fetchById(@Path("id") name: Int): Call<List<MessageResponse>>
    @GET("search-by-emitter-receiver/{emitterId}/{receiverId}")
    fun getMessage(@Path("emitterId") emitterId: Int, @Path("receiverId") receiverId: Int): Call<List<MessageResponse>>
    @POST("add-message")
    fun addMessage(): Call<MessageResponse>
}