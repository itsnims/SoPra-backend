package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.Constant.GameStatus;
import ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {

    @Id
    @Column(unique=true)
    private String name;

    @Column
    private String owner;


    @Column
    private int maxplayer;

    @Column
    private Boolean protection;

    @Column
    private String password;

    @Column
    private GameStatus gameStatus;

    @OneToMany
    public List<Player> players = new ArrayList<Player>(4);

    @OneToOne
    private Market market;

    @JsonIgnore
    @Transient
    private int roundNum=0;


    @Transient
    private int i;

    @Transient
    private  Player winner;

    @Column
    private int current;



    public Game(){}

    public void gameSetup(){

        Market market = Market.getInstance();
        market.marketsetup();
        for (int j = 0; j < players.size();j++){
            players.get(j).setPlayerColor(PlayerColor.values()[j]);
            PlayerColor color = players.get(j).getPlayerColor();
            players.get(j).setup();
            players.get(j).setTurn(false);

            /**all get their drawpile **/
            /** players.get(j).getMyFigure().setCurrentPosition(); **/
        }




    }

    public void addPlayer(Player player){ players.add(player); }

    public Player round(){
        while(! new EndGameManager().CheckifReached()) {

            for (i = 0; i < players.size(); i++) {
                players.get(i).setTurn(true);
                while( players.get(i).getTurn() && players.get(i).handcards.size() > 0) {
                    /**Turn choice = get user input of what his choice is--
                     Players.get(i).executeTurn(choice); **/
                }

            }
            roundNum = roundNum + 1;

        }
        winner = new EndGameManager().getWinner();
        return winner;

    }



    public int getRoundNum(){
        return roundNum;
    }

    public List<Player> getPlayers() {
        return players;
    }



    @Transient
    @JsonIgnore
    public int getNumFigures(){
        return players.size();
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }



    public void setOwner(String owner) {
        this.owner = owner;
    }




    public int getMaxplayer() {
        return maxplayer;
    }

    public void setMaxplayer(int maxplayer) {
        this.maxplayer = maxplayer;
    }


    public void addUser(Player player){
        players.add(player);
        current ++;


    }

    public int getCurrent() {
        return current;
    }


    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }


    public void deletePlayer(Player player){
        players.remove(player);

        current --;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getProtection() {
        return protection;
    }

    public void setProtection(Boolean protection) {
        this.protection = protection;
    }
}
