package me.bertilfrigaard.tether.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "block_members",
    foreignKeys = [
        ForeignKey(
            entity = BlockEntity::class,
            parentColumns = ["id"],
            childColumns = ["blockId"],
            onDelete = CASCADE
        )
    ],
    indices = [Index("blockId")]
)
data class BlockMemberEntity (
    @PrimaryKey
    val packageName: String,
    val blockId: Long
)
