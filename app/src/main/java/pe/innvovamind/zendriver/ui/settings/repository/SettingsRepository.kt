package pe.innvovamind.zendriver.ui.settings.repository


import pe.innvovamind.zendriver.ui.settings.data.model.Driver
import pe.innvovamind.zendriver.ui.settings.data.remote.SettingsResponse
import pe.innvovamind.zendriver.ui.settings.data.remote.SettingsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SettingsRepository(
    val SettingsService: SettingsService
) {
    fun fetchbyId(id: Int): Driver {
        val fetchbyid = SettingsService.fetchUserData(id)
        lateinit var driver : Driver
        fetchbyid.enqueue(object: Callback<SettingsResponse>{
            override fun onResponse(
                call: Call<SettingsResponse>,
                response: Response<SettingsResponse>
            ) {
                if (response.isSuccessful) {
                    driver = response.body()!!.result
                }
            }

            override fun onFailure(call: Call<SettingsResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return driver
    }
}