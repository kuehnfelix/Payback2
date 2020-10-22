package de.kuehnfelix.payback2.database.codecs;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationCodec implements Codec<Location> {

    private final Codec<Document> documentCodec;

    public LocationCodec() {
        this.documentCodec = new DocumentCodec();
    }

    public LocationCodec(final Codec<Document> codec) {
        this.documentCodec = codec;
    }

    @Override
    public Location decode(BsonReader bsonReader, DecoderContext decoderContext) {
        return null;
    }

    @Override
    public void encode(BsonWriter bsonWriter, Location location, EncoderContext encoderContext) {
        final Document document = new Document();

        final World world = location.getWorld();
        final double x = location.getX();
        final double y = location.getY();
        final double z = location.getZ();

        if(world != null) {
            document.put("uuid", world.getUID().toString());
        }

        document.put("x", x);
        document.put("y", y);
        document.put("z", z);

        this.documentCodec.encode(bsonWriter, document, encoderContext);
    }

    @Override
    public Class<Location> getEncoderClass() {
        return Location.class;
    }
}
