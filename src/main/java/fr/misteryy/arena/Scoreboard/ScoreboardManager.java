package fr.misteryy.arena.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class ScoreboardManager {
    public Player player;
    public ScoreboardSign sign;
    public static Map<Player, ScoreboardSign> scoreboard = new HashMap<>();
    public ScoreboardManager(Player player){
        player = player;
        sign = new ScoreboardSign(player, player.getName());
        scoreboard.put(player, this.sign);
    }
    public void loadScoreboard(){
        for(Player player : Bukkit.getOnlinePlayers()){
            sign.setObjectiveName("§6• §5§lARENA §6•");
            sign.create();
        }
    }
}

