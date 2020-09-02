package me.luminescence.togglepvp;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PVPListener implements Listener {

    @EventHandler
    public void onAttack (EntityDamageByEntityEvent e) {

        Main main = JavaPlugin.getPlugin(Main.class);

        if (e.getEntity() instanceof Player) {

            Player attacker = (Player) e.getDamager();
            Player defender = (Player) e.getEntity();

            if (main.enabled.contains(defender)) {

                if (main.enabled.contains(attacker)) {

                    e.setCancelled(false);
                    main.pvpCoolDown.put(attacker, System.currentTimeMillis() + (main.getConfig().getInt("PVPTimer")) * 1000);
                    main.pvpCoolDown.put(defender, System.currentTimeMillis() + (main.getConfig().getInt("PVPTimer")) * 1000);


                } else {

                    e.setCancelled(true);
                    attacker.sendMessage(ChatColor.RED + "You must enable PVP before hitting this player");

                }

            } else {

                e.setCancelled(true);
                attacker.sendMessage(ChatColor.RED + "The other player must enable PVP before you can hit them!");


            }
        }





    }



}
