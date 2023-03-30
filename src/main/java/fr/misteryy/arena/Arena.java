package fr.misteryy.arena;

import fr.misteryy.arena.Commands.SuicideCommands;
import fr.misteryy.arena.Listeners.*;
import fr.misteryy.arena.Scoreboard.ScoreboardRunnable;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.*;

public final class Arena extends JavaPlugin implements Listener {
    private List<Block> placedBlocks = new ArrayList<Block>();
    private List<Block> liquidBlocks = new ArrayList<Block>();


    @Override
    public void onEnable() {
        getCommand("suicide").setExecutor(new SuicideCommands(this));
        getServer().getPluginManager().registerEvents(new Chat(),this);
        getServer().getPluginManager().registerEvents(new PlayerQuiListener(),this);
        getServer().getPluginManager().registerEvents(new ArenaListener(),this);
        getServer().getPluginManager().registerEvents(new NoWeather(),this);
        getServer().getPluginManager().registerEvents(new DeathListeners(),this);
        ScoreboardRunnable scoreboardRunnable = new ScoreboardRunnable();
        scoreboardRunnable.runTaskTimer(this, 0,20);
        getServer().getPluginManager().registerEvents(this,this);
        new BukkitRunnable(){
            @Override
            public void run() {
                for(Block b : placedBlocks){
                    b.breakNaturally();
                }
                placedBlocks.clear();
            }
        }.runTaskTimer(this,3600L,3600L);
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

        }
        @EventHandler
        public void onBlockPlace(BlockPlaceEvent e){
            placedBlocks.add(e.getBlock());
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){

        if(isBlockInProtectedArea(e.getBlock())){
            e.setCancelled(true);
        }
    }
    private boolean isBlockInProtectedArea(Block block) {
        return false;
    }

    @Override
    public void onDisable() {
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.cancelTasks(this);
    }
}
