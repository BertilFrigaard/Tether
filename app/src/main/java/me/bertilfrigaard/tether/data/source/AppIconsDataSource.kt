package me.bertilfrigaard.tether.data.source

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppIconsDataSource(private val context: Context) {
    private val iconCache = mutableMapOf<String, Drawable>()

    suspend fun getIcon(pkg: String): Drawable? {
        iconCache[pkg]?.let { return it }

        return withContext(Dispatchers.IO) {
            try {
                context.packageManager.getApplicationIcon(pkg)
                    .also { iconCache[pkg] = it }
            } catch (e: Exception) {
                Log.e("AppSelector", "Failed to load icon for $pkg", e)
                null
            }
        }
    }
}
