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

    }

    @Override
    public Class<DBLocation> getEncoderClass() {
        return DBLocation.class;
    }
}
