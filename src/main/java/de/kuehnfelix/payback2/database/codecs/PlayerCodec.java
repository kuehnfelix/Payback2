package de.kuehnfelix.payback2.database.codecs;


import de.kuehnfelix.payback2.database.representation.DBPlayer;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class PlayerCodec implements Codec<DBPlayer> {

    @Override
    public DBPlayer decode(final BsonReader bsonReader, final DecoderContext decoderContext) {
        //TODO implement decode
        return null;
    }

    @Override
    public void encode(final BsonWriter bsonWriter, final DBPlayer dbPlayer, final EncoderContext encoderContext) {
        //TODO implement encode
    }

    @Override
    public Class<DBPlayer> getEncoderClass() {
        return DBPlayer.class;
    }
}
