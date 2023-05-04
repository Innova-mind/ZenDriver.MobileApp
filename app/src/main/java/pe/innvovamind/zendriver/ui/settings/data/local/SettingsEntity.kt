package pe.innvovamind.zendriver.ui.settings.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user-settings")
class SettingsEntity(

    @PrimaryKey
    val id: Int,
    val content: String,
    @ColumnInfo(name = "full_name")
    val fullName: String,
    @ColumnInfo(name = "company_name")
    val companyName: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "phone")
    val phone: String,


)


