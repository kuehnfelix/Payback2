package de.kuehnfelix.payback2.database.codecs;

import de.kuehnfelix.payback2.config.Config;
import de.kuehnfelix.payback2.database.representation.DBPlayer;
import de.kuehnfelix.payback2.database.representation.DBTeam;
import org.bson.BsonDocument;
import org.bson.BsonDocumentWriter;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

public class TeamCodecTest {

    @Test
    public void testTeamCodecEncode() {
        TeamCodec codec = new TeamCodec();
        BsonDocument document = new BsonDocument();
        final BsonWriter bsonWriter = new BsonDocumentWriter(document);
        final DBTeam dbTeam = new DBTeam(
                "TestTeam",
                Arrays.asList(
                        new DBPlayer("TestPlayer1"),
                        new DBPlayer("TestPlayer2")
                ),
                1
        );
        final EncoderContext encoderContext = EncoderContext.builder().build();

        codec.encode(bsonWriter, dbTeam, encoderContext);

        String expected = "{\"_id\": \"TestTeam\", \"players\": [\"TestPlayer1\", \"TestPlayer2\"], \"extraLives\": 1}";

        assertEquals("DBTeam Object not successfully encoded!", expected, document.toJson());
    }
}
