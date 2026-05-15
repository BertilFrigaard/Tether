package me.bertilfrigaard.tether.data.repository

import androidx.room.withTransaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.bertilfrigaard.tether.data.local.BlockMemberEntity
import me.bertilfrigaard.tether.data.local.TetherDatabase
import me.bertilfrigaard.tether.data.mapper.toDomain
import me.bertilfrigaard.tether.data.mapper.toEntity
import me.bertilfrigaard.tether.data.model.Block

class BlockRepository(
    private val db: TetherDatabase,
) {
    fun observeBlocks(): Flow<List<Block>> = db.blockDao().observeAll().map { blocks -> blocks.map { it.toDomain() } }

    suspend fun getBlock(pkg: String): Block? = db.blockDao().getBlockByPackageName(pkg)?.toDomain()

    suspend fun createBlock(block: Block): Long = db.withTransaction {
        val blockId = db.blockDao().insert(block.toEntity())
        if (block.packageNames.isNotEmpty()) {
            db.blockMemberDao().insertAll(
                block.packageNames.map { BlockMemberEntity(packageName = it, blockId = blockId) }
            )
        }
        blockId
    }

    suspend fun deleteBlock(id: Long) = db.blockDao().delete(id)
}