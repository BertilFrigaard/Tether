package me.bertilfrigaard.tether.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BlockDao {
    @Transaction
    @Query("SELECT * FROM blocks")
    fun observeAll(): Flow<List<BlockWithMembers>>

    @Transaction
    @Query("SELECT * FROM blocks WHERE id = :id")
    fun observeById(id: Long): Flow<BlockWithMembers?>

    @Transaction
    @Query("SELECT * FROM blocks WHERE id IN (SELECT blockId FROM block_members WHERE packageName = :packageName)")
    suspend fun getBlockByPackageName(packageName: String): BlockWithMembers?

    @Insert
    suspend fun insert(block: BlockEntity): Long

    @Update
    suspend fun update(block: BlockEntity)

    @Query("DELETE FROM blocks WHERE id = :id")
    suspend fun delete(id: Long)
}