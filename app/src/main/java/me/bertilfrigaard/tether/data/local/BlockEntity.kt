package me.bertilfrigaard.tether.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.bertilfrigaard.tether.data.model.BlockCondition

@Entity(tableName = "blocks")
data class BlockEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val enabled: Boolean,
    val blockCondition: BlockCondition,
    val dailyUsageLimit: Int,
    val allowPass: Boolean,
    val delayPassGrant: Int,
    val maxPassLength: Int,
    val passCooldown: Int
)