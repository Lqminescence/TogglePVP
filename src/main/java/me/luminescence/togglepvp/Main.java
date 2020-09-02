package me.luminescence.togglepvp;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        //Message
        System.out.println("[TogglePVP] has been enabled successfully!");

        //Listener
        Bukkit.getPluginManager().registerEvents(new PVPListener(), this);
        Bukkit.getPluginManager().registerEvents(new KeepInventoryListener(), this);

        //Command
        getCommand("pvp").setExecutor(new TogglePVPCommand());

        //Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    //Toggle List
    public ArrayList<Player> enabled = new ArrayList<>();

    //CoolDown HashMap
    public HashMap<Player, Long> coolDown = new HashMap<>();
    public HashMap<Player, Long> pvpCoolDown = new HashMap<>();

}
