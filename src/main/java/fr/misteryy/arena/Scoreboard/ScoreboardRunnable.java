package fr.misteryy.arena.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ScoreboardRunnable extends BukkitRunnable {
    @Override
    public void run(){
        for(Player player : Bukkit.getOnlinePlayers()){
            if(ScoreboardManager.scoreboard.get(player) != null){
                ScoreboardSign scoreboard = ScoreboardManager.scoreboard.get(player);
                scoreboard.setLine(8,"");
                scoreboard.setLine(7,"§4»§f§l--------------§4«");
                scoreboard.setLine(6,"§8§l| §fStatistiques:");
                scoreboard.setLine(5,"§1");
                scoreboard.setLine(4,"§8§l| §7Kills: §c" + player.getStatistic(Statistic.PLAYER_KILLS));
                scoreboard.setLine(3,"§8§l| §7Morts: §3" + player.getStatistic(Statistic.DEATHS));
                scoreboard.setLine(2,"§8§l| §7Joueurs: §b" + Bukkit.getOnlinePlayers().size());
                scoreboard.setLine(1,"§4»§f§l--------------§4«");
            }
        }
    }
}
