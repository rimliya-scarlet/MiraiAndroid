package io.github.mzdluo123.mirai.android.miraiconsole

import net.mamoe.mirai.console.plugin.center.PluginCenter
import java.io.File

object AndroidMiraiPluginCenter : PluginCenter {
    override val name: String
        get() = TODO("Not yet implemented")

    override suspend fun fetchPlugin(page: Int): Map<String, PluginCenter.PluginInsight> {
        TODO("Not yet implemented")
    }

    override suspend fun findPlugin(name: String): PluginCenter.PluginInfo? {
        TODO("Not yet implemented")
    }

    override suspend fun refresh() {
        TODO("Not yet implemented")
    }

    override suspend fun <T : Any> T.downloadPlugin(
        name: String,
        progressListener: T.(Float) -> Unit
    ): File {
        TODO("Not yet implemented")
    }
}