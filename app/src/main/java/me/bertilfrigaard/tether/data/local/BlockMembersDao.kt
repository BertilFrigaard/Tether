package me.bertilfrigaard.tether.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface BlockMemberDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(members: List<BlockMemberEntity>)
}