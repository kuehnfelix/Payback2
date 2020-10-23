package de.kuehnfelix.payback2.database.codecs;

import de.kuehnfelix.payback2.database.Database;
import de.kuehnfelix.payback2.database.representation.DBTeam;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;

import java.util.List;
import java.util.stream.Collectors;

public class TeamCodec implements Codec<DBTeam> {

    @Override
    public DBTeam decode(final BsonReader bsonReader, final DecoderContext decoderContext) {
        final Document document = new DocumentCodec(Database.codecRegistry).decode(bsonReader, decoderContext);
        //TODO implement decode

        return null;
    }

    @Override
    public void encode(final BsonWriter bsonWriter, final DBTeam dbTeam, final EncoderContext encoderContext) {
        final Document document = new Document();

        final String name = dbTeam.getName();
        final List<String> players = dbTeam.getPlayers().stream().map(p -> p.getName()).collect(Collectors.toList());
        final int extraLives = dbTeam.getExtraLives();

        if(name != null) {
            document.put("_id", name);
        }

        if(players != null) {
            document.put("players", players);
        }

        document.put("extraLives", extraLives);

        new DocumentCodec(Database.codecRegistry).encode(bsonWriter, document, encoderContext);
    }

    @Override
    public Class<DBTeam> getEncoderClass() {
        return DBTeam.class;
    }
}
