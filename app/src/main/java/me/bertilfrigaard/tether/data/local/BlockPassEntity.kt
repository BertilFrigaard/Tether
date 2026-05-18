package me.bertilfrigaard.tether.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "block_passes")
data class BlockPassEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val packageName: String,
    val expiry: Long,
    val createdAt: Long = System.currentTimeMillis()
)
