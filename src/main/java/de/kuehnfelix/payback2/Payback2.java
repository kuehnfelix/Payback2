package de.kuehnfelix.payback2;

import de.kuehnfelix.payback2.config.Config;
import de.kuehnfelix.payback2.database.Database;
import org.bukkit.plugin.java.JavaPlugin;


public final class Payback2 extends JavaPlugin {

    private static Payback2 plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Config.getConfig().loadConfig();
        Config.DB db = Config.getConfig().getDb();
        Database.openConnection(db.getUri(), db.getDatabase(), db.getCollection());
    }

    @Override
    public void onDisable() {
        Database.closeConnection();
    }

    public static Payback2 getPlugin() {
        return plugin;
    }
}
