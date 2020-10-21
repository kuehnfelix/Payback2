package de.kuehnfelix.payback2.database.representation;

import org.bson.codecs.pojo.annotations.BsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class DBPlayer {
    private String name;
    private DBLocation location;
    private int folgen;
    private boolean clearInv;
    private boolean alive;
    private int strikes;
    @BsonIgnore
    private DBTeam team;
    private List<DBPlayer> killed;

    public DBPlayer(String name, DBLocation location, int folgen, boolean clearInv, boolean alive, int strikes, DBTeam team, List<DBPlayer> killed) {
        this.name = name;
        this.location = location;
        this.folgen = folgen;
        this.clearInv = clearInv;
        this.alive = alive;
        this.strikes = strikes;
        this.team = team;
        this.killed = killed;
    }

    public DBPlayer(String name) {
        this.name = name;
        location = new DBLocation(null, 0,0,0);
        folgen = 0;
        clearInv = false;
        alive = true;
        strikes = 0;
        team = null;
        killed = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String id) {
        this.name = id;
        //TODO update Database
    }

    public DBLocation getLocation() {
        return location;
    }

    public void setLocation( DBLocation location) {
        this.location = location;
        //TODO update Database
    }

    public int getFolgen() {
        return folgen;
    }

    public void setFolgen(int folgen) {
        this.folgen = folgen;
        //TODO update Database
    }

    public boolean isClearInv() {
        return clearInv;
    }

    public void setClearInv(boolean clearInv) {
        this.clearInv = clearInv;
        //TODO update Database
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
        //TODO update Database
    }

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
        //TODO update Database
    }

    public DBTeam getTeam() {
        return team;
    }

    public void setTeam(DBTeam team) {
        this.team = team;
        //TODO update Database
    }

    public List<DBPlayer> getKilled() {
        return killed;
    }

    public void setKilled(List<DBPlayer> killed) {
        this.killed = killed;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position=" + location +
                ", folgen=" + folgen +
                ", clearInv=" + clearInv +
                ", alive=" + alive +
                ", strikes=" + strikes +
                ", team=" + team.getName() +
                ", killed=[" + killed.toString() +
                "]}";
    }
}
