package me.bertilfrigaard.tether.data.local

import androidx.room.Embedded
import androidx.room.Relation

data class BlockWithMembers (
    @Embedded val block: BlockEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "blockId"
    )
    val members: List<BlockMemberEntity>
)