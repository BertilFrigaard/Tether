package me.bertilfrigaard.tether.data.model

enum class BlockCondition(val label: String) {
    ON_FIRST_OPEN("Always intervene"),
    AFTER_DAILY_USAGE_LIMIT("After daily usage limit is hit")
}
