package me.bertilfrigaard.tether.data.source

import android.app.usage.UsageEvents
import android.app.usage.UsageStatsManager
import android.content.Context
import android.icu.util.Calendar
import android.util.Log

class UsageStatsDataSource(private val context: Context) {

    fun getForegroundApp(): String? {
        val usageStatsManager = context.getSystemService(UsageStatsManager::class.java)
        if (usageStatsManager == null) {
            Log.e("UsageStatsDataSource", "UsageStatsManager is null")
            return null
        }

        val now = System.currentTimeMillis()

        val usageEvents = usageStatsManager.queryEvents(now - QUERY_INTERVAL_MS, now)
        val event = UsageEvents.Event()

        var lastPkg: String? = null
        var lastTs = 0L

        while (usageEvents.hasNextEvent()) {
            usageEvents.getNextEvent(event)
            if (event.eventType == UsageEvents.Event.ACTIVITY_RESUMED
                && event.timeStamp > lastTs
            ) {
                lastPkg = event.packageName
                lastTs = event.timeStamp
            }
        }

        return lastPkg
    }

    fun getUsageToday(pkg: String): Long {
        val usageStatsManager = context.getSystemService(UsageStatsManager::class.java)
        if (usageStatsManager == null) {
            Log.e("UsageStatsDataSource", "UsageStatsManager is null")
            return 0L
        }

        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }

        val startOfDay = calendar.timeInMillis
        val now = System.currentTimeMillis()

        val stats = usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_DAILY,
            startOfDay,
            now
        )

        val pkgStats = stats.find { it.packageName == pkg }

        if (pkgStats == null) {
            Log.w("UsageStatsDataSource", "Package $pkg not found in usage stats")
            return 0L
        }

        return pkgStats.totalTimeInForeground + now - pkgStats.lastTimeUsed
    }

    companion object {
        private const val QUERY_INTERVAL_MS = 10_000
    }
}