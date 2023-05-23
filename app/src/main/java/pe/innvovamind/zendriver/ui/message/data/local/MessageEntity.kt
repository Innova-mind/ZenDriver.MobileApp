package pe.innvovamind.zendriver.ui.message.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "messages")
class MessageEntity (
    @PrimaryKey
    val id: Int,
    val content: String,
    @ColumnInfo(name = "emitter_id")
    val emitter: Int,
    @ColumnInfo(name = "receiver_id")
    val receiver: Int,
    @ColumnInfo(name = "created_at")
    val createdAt: Date,
)