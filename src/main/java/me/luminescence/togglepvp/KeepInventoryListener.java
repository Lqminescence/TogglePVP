package me.luminescence.togglepvp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class KeepInventoryListener implements Listener {

    @EventHandler
    public void onDeath (PlayerDeathEvent e) {

        Main main = JavaPlugin.getPlugin(Main.class);

        Player player = e.getEntity().getPlayer();

        if (main.enabled.contains(player)) {

            e.setKeepInventory(false);
            e.setKeepLevel(false);

        } else {

            e.setKeepInventory(true);
            e.setKeepLevel(true);

        }


    }


}
