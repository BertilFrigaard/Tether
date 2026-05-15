package me.bertilfrigaard.tether.data.source

import android.app.usage.UsageEvents
import android.app.usage.UsageStatsManager
import android.content.Context
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

    companion object {
        private const val QUERY_INTERVAL_MS = 10_000
    }
}