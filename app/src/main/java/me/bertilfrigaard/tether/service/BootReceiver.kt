package me.bertilfrigaard.tether.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (
            intent?.action == Intent.ACTION_BOOT_COMPLETED ||
            intent?.action == Intent.ACTION_MY_PACKAGE_REPLACED
        ) {
            if (context == null) return
            val serviceIntent = Intent(context, DetectionService::class.java)
            context.startForegroundService(serviceIntent)
        }
    }
}