package de.kuehnfelix.payback2.database.codecs;

import com.mongodb.MongoClientSettings;
import de.kuehnfelix.payback2.database.representation.DBLocation;
import de.kuehnfelix.payback2.database.representation.DBPlayer;
import de.kuehnfelix.payback2.database.representation.DBTeam;
import org.bson.*;
import org.bson.codecs.*;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.bson.codecs.configuration.CodecRegistries.*;
import static org.junit.Assert.assertEquals;

public class PlayerCodecTest {

    @Test
    public void testPlayerCodecEncode() {
        final CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                fromCodecs(new LocationCodec()),
                fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );

        final PlayerCodec codec = new PlayerCodec(new DocumentCodec(pojoCodecRegistry));
        final BsonDocument document = new BsonDocument();
        final BsonWriter bsonWriter = new BsonDocumentWriter(document);
        final EncoderContext encoderContext = EncoderContext.builder().build();

        final DBPlayer dbTeam = new DBPlayer(
                "TestPlayer",
                new DBLocation(UUID.fromString("416fe683-a3f3-437d-9a03-c805a35b0a36"), 0, 0, 0),
                2,
                false,
                true,
                0,
                new DBTeam("TestTeam", null, 1),
                Arrays.asList(new DBPlayer("TestPlayer"))
        );

        codec.encode(bsonWriter, dbTeam, encoderContext);

        final String expected = "{\"_id\": \"TestPlayer\", " +
                "\"location\": {\"uuid\": \"416fe683-a3f3-437d-9a03-c805a35b0a36\", \"x\": 0, \"y\": 0, \"z\": 0}, " +
                "\"folgen\": 2, \"clearInv\": false, \"alive\": true, \"strikes\": 0, \"team\": \"TestTeam\"," +
                " \"killed\": [\"TestPlayer\"]}";

        assertEquals("DBPlayer Object not successfully encoded!", expected, document.toJson());
    }
}
