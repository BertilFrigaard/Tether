package me.bertilfrigaard.tether

import android.app.Application
import me.bertilfrigaard.tether.data.source.InstalledAppsDataSource

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    val installedAppsDataSource by lazy { InstalledAppsDataSource(this) }

    companion object {
        lateinit var instance: MainApplication
            private set
    }
}
