package de.kuehnfelix.payback2.database.representation;

import de.kuehnfelix.payback2.config.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBTeam {
    private String id;
    private List<DBPlayer> players;
    private int extraLives;

    public DBTeam(String name) {
        this.id = name;
        extraLives = Config.getConfig().getGameplay().getExtraTeamLives();
    }

    public DBTeam(String name, List<DBPlayer> players, int extraLives) {
        this.id = name;
        this.players = players;
        this.extraLives = extraLives;
    }

    public String getName() {
        return id;
    }

    public void setName(String name) {
        this.id = name;
    }

    public List<DBPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<DBPlayer> players) {
        this.players = players;
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
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + id + '\'' +
                ", players=" + players.toString() +
                ", extraLives=" + extraLives +
                '}';
    }
}
