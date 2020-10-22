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

public class LocationCodec implements Codec<DBLocation> {

    private final Codec<Document> documentCodec;

    public LocationCodec() {
        this.documentCodec = new DocumentCodec();
    }

    public LocationCodec(final Codec<Document> codec) {
        this.documentCodec = codec;
    }

    @Override
    public DBLocation decode(BsonReader bsonReader, DecoderContext decoderContext) {
        return null;
    }

    @Override
    public void encode(BsonWriter bsonWriter, DBLocation dbLocation, EncoderContext encoderContext) {
        final Document document = new Document();

        final String uuid = dbLocation.getWorld().toString();
        final int x = dbLocation.getX();
        final int y = dbLocation.getY();
        final int z = dbLocation.getZ();

        if(uuid != null) {
            document.put("uuid", uuid);
        }

        document.put("x", x);
        document.put("y", y);
        document.put("z", z);

        this.documentCodec.encode(bsonWriter, document, encoderContext);
    }

    @Override
    public Class<DBLocation> getEncoderClass() {
        return DBLocation.class;
    }
}
