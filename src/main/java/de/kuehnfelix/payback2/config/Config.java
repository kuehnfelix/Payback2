package de.kuehnfelix.payback2.config;

import de.kuehnfelix.payback2.Payback2;
import org.bukkit.configuration.file.FileConfiguration;


/**
 * Singleton that loads and stores all the config data.
 */
public class Config {

    private static Config instance; //Singleton instance

    private DB db;

    private Config() {} //prevent instantiation from other classes

    public static Config getConfig() {
        if(instance==null) {
            instance = new Config();
        }
        return instance;
    }

    public void loadConfig() {
        FileConfiguration cfg = Payback2.getPlugin().getConfig();
        cfg.addDefault("uri", "");
        cfg.addDefault("database", "");
        cfg.addDefault("collection", "");
        cfg.options().copyDefaults(true);
        Payback2.getPlugin().saveConfig();

        db = new DB(
                cfg.getString("uri"),
                cfg.getString("database"),
                cfg.getString("collection")
        );
    }

    public DB getDb() {
        return db;
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
}
