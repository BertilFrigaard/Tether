package me.bertilfrigaard.tether.data.model

data class Block(
    val id: Long  = 0,
    val name: String,
    val enabled: Boolean,
    val blockCondition: BlockCondition, // When should an app be blocked
    val dailyUsageLimit: Int, // In minutes. For blockCondition = AFTER_DAILY_USAGE_LIMIT
    val allowPass: Boolean,
    val delayPassGrant: Int, // Seconds from opening the app to allowing granting a pass
    val maxPassLength: Int, // Maximum length of a pass in minutes
    val passCooldown: Int, // Minute time before another pass can be granted.
    val packageNames: List<String>
)