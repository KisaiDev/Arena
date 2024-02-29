package fr.misteryy.arena.Commands;

import fr.misteryy.arena.Arena;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SuicideCommands implements CommandExecutor {
    public SuicideCommands(Arena main){
        main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("suicide")){
                if(player.getHealth() > 20){
                player.setHealth(0);
                } else{
                    player.sendMessage("§c§lVous avez pris des dégât vous ne pouvez pas utiliser cette commande.")
                }
            }
        }
        return false;
    }
}
