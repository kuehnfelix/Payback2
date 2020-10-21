package de.kuehnfelix.payback2.database.representation;

import de.kuehnfelix.payback2.config.Config;
import org.bson.codecs.pojo.annotations.BsonId;

import java.util.ArrayList;
import java.util.List;

public class DBTeam {
    @BsonId
    private String name;
    private List<DBPlayer> players;
    private int extraLives;

    public DBTeam(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        extraLives = Config.getConfig().getGameplay().getExtraTeamLives();
    }

    public DBTeam(String name, List<DBPlayer> players, int extraLives) {
        this.name = name;
        this.players = players;
        this.extraLives = extraLives;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //TODO update Database
    }

    public List<DBPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<DBPlayer> players) {
        this.players = players;
        //TODO update Database
    }

    public void addPlayer(DBPlayer p) {
        if(players==null) {
            players = new ArrayList<>();
        }
        players.add(p);
    }

    public int getExtraLives() {
        return extraLives;
    }

    public void setExtraLives(int extraLives) {
        this.extraLives = extraLives;
        //TODO update Database
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", players=" + players.toString() +
                ", extraLives=" + extraLives +
                '}';
    }
}
