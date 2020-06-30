package io.github.mzdluo123.mirai.android.miraiconsole

import android.util.Log
import io.github.mzdluo123.mirai.android.BotApplication
import io.github.mzdluo123.mirai.android.utils.LoopQueue
import net.mamoe.mirai.utils.MiraiLoggerPlatformBase
import org.jetbrains.annotations.NotNull
import java.io.PrintWriter
import java.io.StringWriter

object AndroidMiraiLogger : MiraiLoggerPlatformBase() {
    private val logBuffer = BotApplication.getSettingPreference()
        .getString("log_buffer_preference", "300")!!.toInt()
    private val printToLogcat =
        BotApplication.getSettingPreference().getBoolean("print_to_logcat_preference", false)
    private val logStorage = LoopQueue<String>(logBuffer)
    override val identity = ""


    override fun debug0(message: String?, e: Throwable?) {
        addLog("[DEBUG] $e")
        addLog(e ?: return)
    }

    override fun error0(message: String?, e: Throwable?) {
        addLog("[ERROR] $e")
        addLog(e ?: return)
    }

    override fun info0(message: String?, e: Throwable?) {
        addLog("[INFO] $e")
        addLog(e ?: return)
    }

    override fun verbose0(message: String?, e: Throwable?) {
        addLog("[VARBOSE] $e")
        addLog(e ?: return)
    }

    override fun warning0(message: String?, e: Throwable?) {
        addLog("[WARNING] $e")
        addLog(e ?: return)
    }

    fun getLogArray(): Array<@NotNull String> {
        return logStorage.toArray()
    }

    fun clear() {
        logStorage.clear()
    }

    private fun addLog(str: String) {
        logStorage.add(str)
        if (printToLogcat) {
            Log.i("MA", str)
        }
    }

    private fun addLog(e: Throwable) {
        val errors = StringWriter()
        e.printStackTrace(PrintWriter(errors))
        addLog(e.toString())
    }


}