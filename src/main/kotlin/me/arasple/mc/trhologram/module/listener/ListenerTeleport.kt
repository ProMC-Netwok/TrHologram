package me.arasple.mc.trhologram.module.listener

import me.arasple.mc.trhologram.module.display.Hologram
import org.bukkit.event.player.PlayerTeleportEvent
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.submit

/**
 * @author Arasple
 * @date 2021/2/12 13:58
 */
object ListenerTeleport {

    @SubscribeEvent
    fun onTeleport(e: PlayerTeleportEvent) {
        submit(async = true) {
            if (!e.player.hasMetadata("NPC")) Hologram.refreshAll(e.player)
        }
    }

}