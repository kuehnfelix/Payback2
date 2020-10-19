package de.kuehnfelix.payback2.database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import de.kuehnfelix.payback2.Payback2;
import de.kuehnfelix.payback2.database.representation.DBTeam;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.logging.Level;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Database {

    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<DBTeam> collection;

    public static void openConnection(String uri, String database, String collection) {
        if(mongoClient != null) {
            mongoClient.close();
        }

        CodecRegistry pojoCodecRegistry = fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );

        MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(uri))
            .codecRegistry(pojoCodecRegistry)
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
