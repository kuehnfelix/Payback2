package de.kuehnfelix.payback2.config;

import com.mongodb.MongoClientURI;
import de.kuehnfelix.payback2.Payback2;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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
                new MongoClientURI(cfg.getString("uri")),
                cfg.getString("database"),
                cfg.getString("collection")
        );
    }

    public DB getDb() {
        return db;
    }

    public class DB {
        private MongoClientURI uri;
        private String database;
        private String collection;

        public DB(MongoClientURI uri, String database, String collection) {
            this.uri = uri;
            this.database = database;
            this.collection = collection;
        }

        public MongoClientURI getUri() {
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
