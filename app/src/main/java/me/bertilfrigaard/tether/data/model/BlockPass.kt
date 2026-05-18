package me.bertilfrigaard.tether.data.model

data class BlockPass(
    val id: Long = 0,
    val packageName: String,
    val expiry: Long,
    val createdAt: Long = System.currentTimeMillis()
)