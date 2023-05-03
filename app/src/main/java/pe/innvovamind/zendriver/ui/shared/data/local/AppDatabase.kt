package pe.innvovamind.zendriver.ui.shared.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.innvovamind.zendriver.ui.message.data.local.MessageDao
import pe.innvovamind.zendriver.ui.message.data.local.MessageEntity
import pe.innvovamind.zendriver.ui.notification.data.local.NotificationDao
import pe.innvovamind.zendriver.ui.notification.data.local.NotificationEntity

@Database(entities = [MessageEntity::class, NotificationEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
    abstract fun notificationDao(): NotificationDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            INSTANCE = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "innovamindabel.db"
            )
                .allowMainThreadQueries()
                .build()
            return INSTANCE as AppDatabase
        }
    }
}