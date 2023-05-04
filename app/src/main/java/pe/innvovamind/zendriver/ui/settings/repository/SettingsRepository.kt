package pe.innvovamind.zendriver.ui.settings.repository

import androidx.lifecycle.MutableLiveData
import pe.innvovamind.zendriver.ui.settings.data.local.SettingsDao
import pe.innvovamind.zendriver.ui.settings.data.local.SettingsEntity
import pe.innvovamind.zendriver.ui.settings.data.remote.SettingsService
import java.sql.Driver

interface SettingsRepository {
    suspend fun fetchData(name: String): SettingsEntity

}