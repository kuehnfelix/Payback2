package de.kuehnfelix.payback2.config;

import de.kuehnfelix.payback2.Payback2;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;


/**
 * Singleton that loads and stores all the config data.
 */
public class Config {

    private static Config instance; //Singleton instance

    private DB db;
    private GamePlay gameplay;
    private static final String dbconfigfile = "db.yml";
    private static final String gameplayconfigfile = "gameplay.yml";

    private Config() {} //prevent instantiation from other classes

    public static Config getConfig() {
        if(instance==null) {
            instance = new Config();
        }
        return instance;
    }

    public void loadConfig() {
        try {
            loadDBconfig();
            loadGameplayConfig();
        } catch (IOException e) {
            Payback2.getPlugin().getLogger().log(Level.WARNING, e.getLocalizedMessage());
        }
    }

    private void loadDBconfig() throws IOException {
        File file = new File(Payback2.getPlugin().getDataFolder(), dbconfigfile);
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.addDefault("uri", "");
        cfg.addDefault("database", "");
        cfg.addDefault("collection", "");
        cfg.options().copyDefaults(true);

        cfg.save(file);

        db = new DB(
                cfg.getString("uri"),
                cfg.getString("database"),
                cfg.getString("collection")
        );
    }

    private void loadGameplayConfig() throws IOException {
        File file = new File(Payback2.getPlugin().getDataFolder(), dbconfigfile);
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.addDefault("extraTeamLives", 1);
        cfg.options().copyDefaults(true);

        cfg.save(file);

        gameplay = new GamePlay(cfg.getInt("extraTeamLives"));
    }

    public DB getDb() {
        return db;
    }

    public GamePlay getGameplay() {
        return gameplay;
    }

    public class DB {
        private String uri;
        private String database;
        private String collection;

        public DB(String uri, String database, String collection) {
            this.uri = uri;
            this.database = database;
            this.collection = collection;
        }

        public String getUri() {
            return uri;
        }

        public String getDatabase() {
            return database;
        }

        public String getCollection() {
            return collection;
        }
    }

    public class GamePlay {
        private int extraTeamLives;

        public GamePlay(int extraTeamLives) {
            this.extraTeamLives = extraTeamLives;
        }

        public int getExtraTeamLives() {
            return extraTeamLives;
        }
    }
}
