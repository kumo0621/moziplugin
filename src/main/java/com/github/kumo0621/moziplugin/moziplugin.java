package com.github.kumo0621.moziplugin;

import net.kunmc.lab.commandlib.CommandLib;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class moziplugin extends JavaPlugin implements org.bukkit.event.Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        CommandLib.register(this, new mozicommand());
    }

    public static boolean start = false;

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static int down = 5;
    public static int up = 10;

    @EventHandler
    public void onPlayerchat(PlayerChatEvent e) {
        if (start) {
            String args = e.getMessage();
            if (args.length() <= down) {
                Player player = e.getPlayer();
                Location location = player.getLocation();
                location.getWorld().spawnEntity(location, EntityType.PRIMED_TNT);
            } else if (args.length() >= up) {
                Player player = e.getPlayer();
                Location location = player.getLocation();
                location.getWorld().spawnEntity(location, EntityType.PRIMED_TNT);
            }
        }
    }

}
