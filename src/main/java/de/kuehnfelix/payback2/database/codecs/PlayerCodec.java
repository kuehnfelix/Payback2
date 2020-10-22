package de.kuehnfelix.payback2.database.codecs;


import de.kuehnfelix.payback2.database.representation.DBLocation;
import de.kuehnfelix.payback2.database.representation.DBPlayer;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerCodec implements Codec<DBPlayer> {

    private final Codec<Document> documentCodec;

    public PlayerCodec() {
        this.documentCodec = new DocumentCodec();
    }

    public PlayerCodec(final Codec<Document> codec) {
        this.documentCodec = codec;
    }

    @Override
    public DBPlayer decode(final BsonReader bsonReader, final DecoderContext decoderContext) {
        //TODO implement decode
        return null;
    }

    @Override
    public void encode(final BsonWriter bsonWriter, final DBPlayer player, final EncoderContext encoderContext) {
        final Document document = new Document();

        final String name = player.getName();
        final DBLocation location = player.getLocation();
        final int folgen = player.getFolgen();
        final boolean clearInv = player.isClearInv();
        final boolean alive = player.isAlive();
        final int strikes = player.getStrikes();
        final String team = player.getTeam().getName();
        final List<String> killed = player.getKilled().stream().map(p -> p.getName()).collect(Collectors.toList());

        if(name != null) {
            document.put("_id", name);
        }

        if(location != null) {
            document.put("location", location);
        }

        if(folgen >= 0) {
            document.put("folgen", folgen);
        }

        document.put("clearInv", clearInv);

        document.put("alive", alive);

        if(strikes >= 0) {
            document.put("strikes", strikes);
        }

        if (team != null) {
            document.put("team", team);
        }

        if (killed != null) {
            document.put("killed", killed);
        }

        this.documentCodec.encode(bsonWriter, document, encoderContext);
    }

    @Override
    public Class<DBPlayer> getEncoderClass() {
        return DBPlayer.class;
    }
}
