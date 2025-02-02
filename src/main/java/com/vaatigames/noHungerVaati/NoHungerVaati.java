package com.vaatigames.noHungerVaati;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class NoHungerVaati extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("NoHungerVaati activé !");
    }

    @Override
    public void onDisable() {
        getLogger().info("NoHungerVaati désactivé !");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().setFoodLevel(20);
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof org.bukkit.entity.Player player) {
            if (isInLobbyArea(player)) {
                event.setCancelled(true);
            }
        }
    }

    public boolean isInLobbyArea(org.bukkit.entity.Player player) {
        return Objects.requireNonNull(player.getLocation().getWorld()).getName().equalsIgnoreCase("Lobby");
    }
}