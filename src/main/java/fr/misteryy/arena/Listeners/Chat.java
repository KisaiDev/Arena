package fr.misteryy.arena.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {
    @EventHandler
    public void Chat(AsyncPlayerChatEvent e){
        e.setFormat("§7 " + e.getPlayer().getName() + " §6» §f" + e.getMessage());
    }
}
