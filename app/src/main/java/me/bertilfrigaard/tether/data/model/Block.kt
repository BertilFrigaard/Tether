package me.bertilfrigaard.tether.data.model

data class Block(
    val id: Long,
    val name: String,
    val enabled: Boolean,
    val blockCondition: BlockCondition,
    val dailyUsageLimit: Int,
    val allowPass: Boolean,
    val delayPassGrant: Int,
    val maxPassLength: Int,
    val passCooldown: Int
)