package io.github.mzdluo123.mirai.android.miraiconsole

import io.github.mzdluo123.mirai.android.BotApplication
import io.github.mzdluo123.mirai.android.utils.LoopQueue
import net.mamoe.mirai.utils.MiraiLoggerPlatformBase

object AndroidMiraiLogger : MiraiLoggerPlatformBase(){
    private val logBuffer = BotApplication.getSettingPreference()
        .getString("log_buffer_preference", "300")!!.toInt()

    val logStorage = LoopQueue<String>(logBuffer)
    override val identity = ""
    override fun debug0(message: String?, e: Throwable?) {
        logStorage.add(message)
    }

    override fun error0(message: String?, e: Throwable?) {
        logStorage.add(message)
    }

    override fun info0(message: String?, e: Throwable?) {
        logStorage.add(message)
    }

    override fun verbose0(message: String?, e: Throwable?) {
        logStorage.add(message)
    }

    override fun warning0(message: String?, e: Throwable?) {
        logStorage.add(message)
    }


}