package me.bertilfrigaard.tether.data.mapper

import me.bertilfrigaard.tether.data.local.BlockPassEntity
import me.bertilfrigaard.tether.data.model.BlockPass

fun BlockPass.toEntity(): BlockPassEntity = BlockPassEntity(
    id = id, packageName = packageName, expiry = expiry, createdAt = createdAt
)

fun BlockPassEntity.toDomain(): BlockPass = BlockPass(
    id = id, packageName = packageName, expiry = expiry, createdAt = createdAt
)