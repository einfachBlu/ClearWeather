package de.blu.alwaysday;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClearWeather extends JavaPlugin implements Listener {

  @Override
  public void onEnable() {
    for (World world : Bukkit.getWorlds()) {
      this.initWorld(world);
    }

    Bukkit.getPluginManager().registerEvents(this, this);
  }

  @EventHandler
  public void onWorldLoad(WorldLoadEvent e) {
    World world = e.getWorld();

    this.initWorld(world);
  }

  private void initWorld(World world) {
    world.setThundering(false);
    world.setStorm(false);
    world.setClearWeatherDuration(Integer.MAX_VALUE);
    world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
  }
}
