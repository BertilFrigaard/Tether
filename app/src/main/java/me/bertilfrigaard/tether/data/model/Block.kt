package me.bertilfrigaard.tether.data.model

data class Block(
    val id: Long  = 0,
    val name: String,
    val enabled: Boolean,
    val blockCondition: BlockCondition,
    val dailyUsageLimit: Int,
    val allowPass: Boolean,
    val delayPassGrant: Int,
    val maxPassLength: Int,
    val passCooldown: Int,
    val packageNames: List<String>
)