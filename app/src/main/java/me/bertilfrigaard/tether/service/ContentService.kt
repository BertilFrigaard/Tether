package me.bertilfrigaard.tether.service

import android.accessibilityservice.AccessibilityService
import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

@SuppressLint("AccessibilityPolicy")
class ContentService : AccessibilityService() {
    companion object {
        private val CONTENT_RULES = listOf(
            ContentRule(
                pkgList = listOf("com.snapchat.android"),
                containsAll = listOf("com.snapchat.android:id/spotlight_container")
            ),
            ContentRule(
                pkgList = listOf("com.snapchat.android"),
                containsAll = listOf(
                    "com.snapchat.android:id/df_large_story",
                    "com.snapchat.android:id/base_open_view"
                )
            ),
            ContentRule(
                pkgList = listOf("com.google.android.youtube"),
                containsAll = listOf("com.google.android.youtube:id/reel_watch_fragment_root")
            ),
            ContentRule(
                pkgList = listOf("com.google.android.googlequicksearchbox"),
                containsAll = listOf("com.google.android.googlequicksearchbox:id/googleapp_container")
            )
        )
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        val source = event?.source
        if (source != null) {
            for (rule in CONTENT_RULES) {
                if (rule.match(source)) {
                    performGlobalAction(GLOBAL_ACTION_BACK)
                    Handler(Looper.getMainLooper()).postDelayed({
                        performGlobalAction(GLOBAL_ACTION_HOME)
                    }, 300)
                    break
                }
            }
        }
    }

    override fun onInterrupt() {
        TODO("Not yet implemented")
    }
}

class ContentRule(
    private val pkgList: List<String>,
    private val containsAll: List<String> = emptyList(),
    private val containsOne: List<String> = emptyList()
) {
    fun match(node: AccessibilityNodeInfo): Boolean {
        if (node.packageName !in pkgList) return false
        if (containsAll.all {
                node.findAccessibilityNodeInfosByViewId(it).isNotEmpty()
            }) return true
        if (containsOne.any {
                node.findAccessibilityNodeInfosByViewId(it).isNotEmpty()
            }) return true
        return false
    }
}