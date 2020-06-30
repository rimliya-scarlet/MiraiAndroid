@file:Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER", "INVISIBLE_INTERFACE")

package io.github.mzdluo123.mirai.android.miraiconsole

import io.github.mzdluo123.mirai.android.BotApplication
import io.github.mzdluo123.mirai.android.BuildConfig
import kotlinx.coroutines.GlobalScope
import net.mamoe.mirai.console.MiraiConsole
import net.mamoe.mirai.console.MiraiConsoleFrontEnd
import net.mamoe.mirai.console.plugin.PluginLoader
import net.mamoe.mirai.console.plugin.center.PluginCenter
import net.mamoe.mirai.console.plugin.jvm.JarPluginLoader
import net.mamoe.mirai.utils.MiraiLogger
import java.io.File
import java.util.*
import kotlin.coroutines.CoroutineContext

class AndroidMiraiConsole(val root: File) : MiraiConsole {

    override val buildDate: Date
        get() = Date(BuildConfig.BUILD_TIMESTAMP)
    override val builtInPluginLoaders: List<PluginLoader<*, *>>
        get() = listOf(JarPluginLoader)
    override val coroutineContext: CoroutineContext
        get() = GlobalScope.coroutineContext

    @ExperimentalUnsignedTypes
    override val frontEnd: MiraiConsoleFrontEnd
        get() = AndroidMiraiConsoleFontEnd(BotApplication.context)
    override val mainLogger: MiraiLogger
        get() = AndroidMiraiLogger
    override val pluginCenter: PluginCenter
        get() = AndroidMiraiPluginCenter
    override val rootDir: File
        get() = root
    override val version: String
        get() = BotApplication.context.packageManager.getPackageInfo(
            BotApplication.context.packageName,
            0
        ).versionName

    override fun newLogger(identity: String?): MiraiLogger {
        return AndroidMiraiLogger
    }
}
