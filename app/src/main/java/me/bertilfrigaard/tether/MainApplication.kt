package me.bertilfrigaard.tether

import android.app.Application
import me.bertilfrigaard.tether.data.local.TetherDatabase
import me.bertilfrigaard.tether.data.repository.BlockRepository
import me.bertilfrigaard.tether.data.source.AppIconsDataSource
import me.bertilfrigaard.tether.data.source.InstalledAppsDataSource
import me.bertilfrigaard.tether.data.source.UsageStatsDataSource
import kotlin.getValue

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    private val database by lazy { TetherDatabase.getInstance(this) }
    val blockRepository by lazy { BlockRepository(database) }

    val installedAppsDataSource by lazy { InstalledAppsDataSource(this) }
    val appIconsDataSource by lazy { AppIconsDataSource(this) }
    val usageStatsDataSource by lazy { UsageStatsDataSource(this) }

    companion object {
        lateinit var instance: MainApplication
            private set
    }
}
