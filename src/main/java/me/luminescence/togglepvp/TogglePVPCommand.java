package me.luminescence.togglepvp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TogglePVPCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Main main = JavaPlugin.getPlugin(Main.class);

        Player player = (Player) sender;

        if (main.pvpCoolDown.containsKey(player) && main.pvpCoolDown.get(player) >= System.currentTimeMillis()) {

            player.sendMessage(ChatColor.RED + "You cannot use this command until you are out of combat for" + main.getConfig().getInt("PVPTimer") + " more seconds!");

        } else {


        if (main.coolDown.containsKey(player) && main.coolDown.get(player) >= System.currentTimeMillis()) {

            long timeRemaining = main.coolDown.get(player) - System.currentTimeMillis();

            int intRemaining = (int) ((timeRemaining / 1000) + 1);
            player.sendMessage(ChatColor.RED + "You must wait " + intRemaining + " seconds before toggling PVP again!");



        } else {

            int CDInt = main.getConfig().getInt("coolDownSeconds");

            main.coolDown.put(player, System.currentTimeMillis() + (CDInt * 1000));


            if (main.enabled.contains(player)) {

                player.sendMessage("You have disabled PVP");
                main.enabled.remove(player);

            } else {

                player.sendMessage("You have enabled PVP");
                main.enabled.add(player);

            }
        }

        }

        return false;
    }
}
