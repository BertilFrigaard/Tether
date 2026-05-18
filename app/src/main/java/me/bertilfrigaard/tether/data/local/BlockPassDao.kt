package me.bertilfrigaard.tether.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BlockPassDao {
    @Insert
    suspend fun insert(blockPass: BlockPassEntity): Long

    @Query("SELECT * FROM block_passes WHERE packageName = :packageName ORDER BY createdAt DESC LIMIT 1")
    suspend fun getLatestBlockPass(packageName: String): BlockPassEntity?
}