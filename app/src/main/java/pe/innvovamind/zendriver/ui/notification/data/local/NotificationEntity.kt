package pe.innvovamind.zendriver.ui.notification.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "notifications")
class NotificationEntity (
    @PrimaryKey
    val id: Int,
    val content: String,
    val date: Date,
    @ColumnInfo(name = "emitter_id")
    val emitter: String,
    @ColumnInfo(name = "receiver_id")
    val receiver: String,
)