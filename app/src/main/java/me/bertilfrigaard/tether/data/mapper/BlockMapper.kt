package me.bertilfrigaard.tether.data.mapper

import me.bertilfrigaard.tether.data.local.BlockEntity
import me.bertilfrigaard.tether.data.local.BlockWithMembers
import me.bertilfrigaard.tether.data.model.Block

fun BlockWithMembers.toDomain(): Block = Block(
    id = block.id,
    name = block.name,
    enabled = block.enabled,
    blockCondition = block.blockCondition,
    dailyUsageLimit = block.dailyUsageLimit,
    allowPass = block.allowPass,
    delayPassGrant = block.delayPassGrant,
    maxPassLength = block.maxPassLength,
    passCooldown = block.passCooldown,
    packageNames = members.map { it.packageName },
)

fun Block.toEntity(): BlockEntity = BlockEntity(
    id = id,
    name = name,
    enabled = enabled,
    blockCondition = blockCondition,
    dailyUsageLimit = dailyUsageLimit,
    allowPass = allowPass,
    delayPassGrant = delayPassGrant,
    maxPassLength = maxPassLength,
    passCooldown = passCooldown,
)