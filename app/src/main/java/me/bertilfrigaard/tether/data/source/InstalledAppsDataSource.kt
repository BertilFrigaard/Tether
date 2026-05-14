package me.bertilfrigaard.tether.data.source

import android.content.Context
import android.content.Intent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.bertilfrigaard.tether.data.model.AppInfo

class InstalledAppsDataSource(private val context: Context) {
    suspend fun getLaunchableApps(): List<AppInfo> = withContext(Dispatchers.IO) {
        val pm = context.packageManager
        val intent = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER)
        pm.queryIntentActivities(intent, 0)
            .asSequence()
            .map { it.activityInfo.applicationInfo }
            .distinctBy { it.packageName }
            .filter { it.packageName != context.packageName }
            .map { appInfo ->
                AppInfo(
                    packageName = appInfo.packageName,
                    appLabel = pm.getApplicationLabel(appInfo).toString()
                )
            }
            .sortedBy { it.appLabel }
            .toList()
    }

    fun getApp(pkg: String): AppInfo {
        val pm = context.packageManager
        val appInfo = pm.getApplicationInfo(pkg, 0)
        return AppInfo(
            packageName = appInfo.packageName,
            appLabel = pm.getApplicationLabel(appInfo).toString()
        )
    }
}