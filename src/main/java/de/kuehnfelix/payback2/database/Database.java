package de.kuehnfelix.payback2.database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import de.kuehnfelix.payback2.Payback2;
import de.kuehnfelix.payback2.database.codecs.LocationCodec;
import de.kuehnfelix.payback2.database.codecs.PlayerCodec;
import de.kuehnfelix.payback2.database.codecs.TeamCodec;
import de.kuehnfelix.payback2.database.representation.DBTeam;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.logging.Level;

import static org.bson.codecs.configuration.CodecRegistries.*;

public class Database {

    public static final CodecRegistry codecRegistry = fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            fromCodecs(new PlayerCodec(), new TeamCodec(), new LocationCodec())
    );

    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<DBTeam> collection;

    public static void openConnection(String uri, String database, String collection) {
        if(mongoClient != null) {
            mongoClient.close();
        }

        MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(uri))
            .codecRegistry(codecRegistry)
            .build();

        Database.mongoClient = MongoClients.create(settings);
        Database.database = mongoClient.getDatabase(database);
        Database.collection = Database.database.getCollection(collection, DBTeam.class);
        Payback2.getPlugin().getLogger().log(Level.INFO, "Payback2 has successfully connected to the database!");
    }

    public static void closeConnection() {
        mongoClient.close();
        mongoClient = null;
        database = null;
        collection = null;
    }
}
