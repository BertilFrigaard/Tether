package me.bertilfrigaard.tether.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [BlockEntity::class, BlockMemberEntity::class],
    version = 1,
    exportSchema = true
)
abstract class TetherDatabase : RoomDatabase() {
    abstract fun blockDao(): BlockDao
    abstract fun blockMemberDao(): BlockMemberDao

    companion object {
        @Volatile
        private var INSTANCE: TetherDatabase? = null

        fun getInstance(context: Context): TetherDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    TetherDatabase::class.java,
                    "tether_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}