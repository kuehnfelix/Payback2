package de.kuehnfelix.payback2.database.representation;

import org.bson.codecs.pojo.annotations.BsonId;

import java.util.UUID;

public class DBLocation {
    @BsonId
    private UUID world;
    private int x, y, z;

    public DBLocation( UUID world, int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.world = world;
    }

    public UUID getWorld() {
        return world;
    }

    public void setWorld(UUID world) {
        this.world = world;
        //TODO update Database
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        //TODO update Database
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        //TODO update Database
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
        //TODO update Database
    }
}
