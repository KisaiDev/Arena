package fr.misteryy.arena.Listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuiListener implements Listener {
    public void onQuit(PlayerQuitEvent e){
        e.setQuitMessage("§7[§c-§7] §f" + e.getPlayer().getName());
    }
}
