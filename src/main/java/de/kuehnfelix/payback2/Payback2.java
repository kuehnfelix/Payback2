package de.kuehnfelix.payback2;

import de.kuehnfelix.payback2.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class Payback2 extends JavaPlugin {

    private static Payback2 plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Config.getConfig().loadConfig();
    }

    public static Payback2 getPlugin() {
        return plugin;
    }
}
