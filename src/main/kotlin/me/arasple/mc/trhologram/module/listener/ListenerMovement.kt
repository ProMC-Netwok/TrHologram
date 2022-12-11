package me.arasple.mc.trhologram.module.listener

import me.arasple.mc.trhologram.module.display.Hologram
import org.bukkit.event.player.PlayerMoveEvent
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common5.Baffle
import java.util.concurrent.TimeUnit

/**
 * @author Arasple
 * @date 2021/2/11 9:58
 */
object ListenerMovement {

    val cd = Baffle.of(1, TimeUnit.SECONDS)

    @SubscribeEvent
    fun onMove(e: PlayerMoveEvent) {
        val player = e.player
        // 只检测位置不同情况 不检测玩家原地视角移动情况
        val fromblock = e.from.block
        val toblock = e.to?.block

        if (!cd.hasNext(player.name) && fromblock != toblock) {
            Hologram.refreshAll(player)
        }
    }

}