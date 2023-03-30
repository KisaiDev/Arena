package fr.misteryy.arena.Listeners;

import fr.misteryy.arena.utils.ItemBuilder;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class DeathListeners implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        e.setDeathMessage("§a"+ e.getEntity().getName() + " §7s'est fait tuer par §c" + e.getEntity().getKiller().getName());
        e.setKeepInventory(true);

        Player player = e.getEntity();
        player.getInventory().clear();
    }
    @EventHandler
    public void c(EntityDeathEvent e){
        e.getEntity().getKiller().getInventory().addItem(new ItemBuilder(Material.GOLDEN_APPLE).setAmount(4).toItemStack());
        e.getEntity().getKiller().getInventory().addItem(new ItemBuilder(Material.ARROW).setAmount(8).toItemStack());
        e.getEntity().getKiller().addPotionEffect(new PotionEffect(PotionEffectType.HEAL,1,1,true));
    }
    @EventHandler
    public void f(PlayerRespawnEvent e){
        Player player = e.getPlayer();
        player.getInventory().clear();
        player.setGameMode(GameMode.ADVENTURE);
        player.getInventory().setItem(4,new ItemBuilder(Material.COMPASS,1).setName("§7Arene").setLore("§cPermet de ce tp \n","dans l'arene").setAmount(1).addEnchant(Enchantment.LURE,1).addFlag(ItemFlag.HIDE_ENCHANTS).toItemStack());
    }
}
