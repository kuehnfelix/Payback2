package de.kuehnfelix.payback2.database.codecs;

import de.kuehnfelix.payback2.database.representation.DBPlayer;
import de.kuehnfelix.payback2.database.representation.DBTeam;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;

public class TeamCodec implements Codec<DBTeam> {

    private final Codec<Document> documentCodec;

    public TeamCodec() {
        this.documentCodec = new DocumentCodec();
    }

    public TeamCodec(final Codec<Document> codec) {
        this.documentCodec = codec;
    }

    @Override
    public DBTeam decode(final BsonReader bsonReader, final DecoderContext decoderContext) {
        final Document document = this.documentCodec.decode(bsonReader, decoderContext);
        //TODO implement decode

        return null;
    }

    @Override
    public void encode(BsonWriter bsonWriter, DBTeam dbTeam, EncoderContext encoderContext) {
        //TODO implement encode
    }

    @Override
    public Class<DBTeam> getEncoderClass() {
        return DBTeam.class;
    }
}
