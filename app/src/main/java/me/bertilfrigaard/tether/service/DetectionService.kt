package me.bertilfrigaard.tether.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import me.bertilfrigaard.tether.InterventionActivity
import me.bertilfrigaard.tether.MainApplication
import me.bertilfrigaard.tether.R
import me.bertilfrigaard.tether.data.model.BlockCondition

class DetectionService : Service() {
    private val handler = Handler(Looper.getMainLooper())
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private val pollRunnable = object : Runnable {
        var foregroundApp: String? = null

        override fun run() {
            val currentForegroundApp = MainApplication.instance.usageStatsDataSource.getForegroundApp()

            if (currentForegroundApp != foregroundApp && currentForegroundApp != null) {
                foregroundApp = currentForegroundApp
            }

            scope.launch { performCheck() }

            handler.postDelayed(this, 500)
        }

        private suspend fun performCheck() {
            foregroundApp?.let {
                val block = MainApplication.instance.blockRepository.getBlock(it)

                if (block?.enabled != true) return
                Log.d("DetectionService", "App $it is blocked")

                // If blockCondition = AFTER_DAILY_USAGE_LIMIT check daily usage
                if (block.blockCondition == BlockCondition.AFTER_DAILY_USAGE_LIMIT) {
                    val usageToday = MainApplication.instance.usageStatsDataSource.getUsageToday(it)
                    Log.d("DetectionService", "Usage today: $usageToday")
                    if (usageToday < block.dailyUsageLimit * 60 * 1000) {
                        Log.d("DetectionService", "Usage limit not reached.")
                        return
                    }
                }

                // If block allows for passes, check for valid passes
                if (block.allowPass) {
                    val pass = MainApplication.instance.blockRepository.getLatestBlockPass(it)
                    if (pass != null) {
                        if (pass.expiry >= System.currentTimeMillis()) {
                            Log.d("DetectionService", "Valid pass found")
                            return
                        }
                    }
                }

                // App is blocked, perform intervention
                performIntervention(it)
            }
        }

        private fun performIntervention(pkg: String) {
            val intent = Intent(this@DetectionService, InterventionActivity::class.java).apply {
                addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_NO_HISTORY or
                    Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
                )
                putExtra(InterventionActivity.EXTRA_BLOCKED_PACKAGE, pkg)
            }
            startActivity(intent)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(SERVICE_NOTIFICATION_ID, buildNotification())
        handler.post(pollRunnable)
        return START_STICKY
    }

    override fun onCreate() {
        createNotificationChannel()
        super.onCreate()
    }

    override fun onDestroy() {
        handler.removeCallbacks(pollRunnable)
        super.onDestroy()
    }

    override fun onBind(intent: Intent?) = null

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            SERVICE_NOTIFICATION_CHANNEL_ID,
            "Tether Detection",
            NotificationManager.IMPORTANCE_LOW
        )

        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
    }

    private fun buildNotification(): Notification {
        return NotificationCompat.Builder(
            this,
            SERVICE_NOTIFICATION_CHANNEL_ID
        )
            .setContentTitle("App Detection Service is active")
            .setSmallIcon(R.drawable.abc_24px)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
    }

    companion object {
        const val SERVICE_NOTIFICATION_ID = 1
        const val SERVICE_NOTIFICATION_CHANNEL_ID = "app_detection_service"
    }
}