package fr.misteryy.arena.Listeners;

import fr.misteryy.arena.Scoreboard.ScoreboardManager;
import fr.misteryy.arena.utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArenaListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        if(!ScoreboardManager.scoreboard.containsKey(player)){
            new ScoreboardManager(player).loadScoreboard();
        }
        e.setJoinMessage("§7[§a+§7] §f" + e.getPlayer().getName());
        player.getInventory().clear();
        player.setGameMode(GameMode.ADVENTURE);
        player.setHealth(20);
        player.setSaturation(20);
        player.teleport(new Location(Bukkit.getWorld("world"),181,117,-1277));
        player.playSound(player.getLocation(), Sound.ORB_PICKUP,1,1);
        player.getInventory().setItem(4,new ItemBuilder(Material.COMPASS,1).setName("§7Arene").setLore("§cPermet de ce tp \n","dans l'arene").setAmount(1).addEnchant(Enchantment.LURE,1).addFlag(ItemFlag.HIDE_ENCHANTS).toItemStack());
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player player = e.getPlayer();
        Action action = e.getAction();
        ItemStack it = e.getItem();
        if(it == null) return;
        if(it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§7Arene")){
            if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
                player.getInventory().clear();
                player.teleport(new Location(Bukkit.getWorld("world"),174.132,23,-1257.2,-133.2f,-5.0f));
                player.setGameMode(GameMode.SURVIVAL);
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,255,255));
                player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,255,255));

                player.getInventory().setHelmet(new ItemBuilder(Material.DIAMOND_HELMET).setAmount(1).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,2).setUnbreakable(true).toItemStack());
                player.getInventory().setChestplate(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setAmount(1).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,2).setUnbreakable(true).toItemStack());
                player.getInventory().setLeggings(new ItemBuilder(Material.IRON_LEGGINGS).setAmount(1).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3).setUnbreakable(true).toItemStack());
                player.getInventory().setBoots(new ItemBuilder(Material.DIAMOND_BOOTS).setAmount(1).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,2).setUnbreakable(true).toItemStack());
                player.getInventory().setItem(0,new ItemBuilder(Material.DIAMOND_SWORD).setAmount(1).addEnchant(Enchantment.DAMAGE_ALL,3).setUnbreakable(true).setLore("§7Vasy \n","§cTape Fort").toItemStack());
                player.getInventory().setItem(1,new ItemBuilder(Material.GOLDEN_APPLE).setAmount(12).toItemStack());
                player.getInventory().setItem(2,new ItemBuilder(Material.BOW).setAmount(1).addEnchant(Enchantment.ARROW_DAMAGE,2).setUnbreakable(true).setLore("§cCes Pas Bien\n","§cDe SpamBow").toItemStack());
                player.getInventory().setItem(12,new ItemBuilder(Material.ARROW).setAmount(16).toItemStack());
                player.getInventory().setItem(3,new ItemBuilder(Material.WATER_BUCKET).setAmount(1).toItemStack());
                player.getInventory().setItem(30,new ItemBuilder(Material.WATER_BUCKET).setAmount(1).toItemStack());
                player.getInventory().setItem(4,new ItemBuilder(Material.LAVA_BUCKET).setAmount(1).toItemStack());
                player.getInventory().setItem(31,new ItemBuilder(Material.LAVA_BUCKET).setAmount(1).toItemStack());
                player.getInventory().setItem(8,new ItemBuilder(Material.COBBLESTONE).setAmount(64).toItemStack());
                player.getInventory().setItem(7,new ItemBuilder(Material.COBBLESTONE).setAmount(64).toItemStack());
                player.getInventory().setItem(35,new ItemBuilder(Material.COBBLESTONE).setAmount(64).toItemStack());
                player.getInventory().setItem(34,new ItemBuilder(Material.COBBLESTONE).setAmount(64).toItemStack());
                player.getInventory().setItem(6,new ItemBuilder(Material.COOKED_BEEF).setAmount(64).toItemStack());
            }
        }
    }
}
