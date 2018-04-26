package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.Constant.GameStatus;
import ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Blockade;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;

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
    private String pathname;

    @Column
    private Boolean protection = false;

    @Column
    private String password;

    @Column
    private GameStatus gameStatus;

    @OneToMany
    public List<Player> players = new ArrayList<Player>(4);

    @OneToOne(cascade = {CascadeType.ALL})
    private Market market = Market.getInstance();

    @JsonIgnore
    @Transient
    private int roundNum=0;


    @Transient
    private int i;

    @Transient
    private  Player winner;

    @Column
    private int current;

    @OneToOne
    private Player currentPlayer;

    @JsonIgnore
    @Transient
    private Path GamePath = new Path();

    /**steps when crossing blockade:
     * 1. from field: getBlockadeFromNeighbours()
     * 2. blockade: setCrossed()
     * 3. blockade: removeBlockade(...) -->removes from neighbours this blockade and sets new neighbours*/


    public Game(){}

    public void gameSetup() {

        Path path = new Path();
        List<Field> starters = path.getStartingFields();
        market.marketsetup();
        for (int j = 0; j < players.size(); j++) {
            players.get(j).setPlayerColor(PlayerColor.values()[j]);
            players.get(j).getMyFigure().setCurrentPosition(starters.get(j));
            players.get(j).setup();
            players.get(j).setTurn(false);

            /**all get their drawpile **/
            /** players.get(j).getMyFigure().setCurrentPosition(); **/
        }
        setCurrentPlayer(players.get(0));

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


    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public void setPathname(String name){
        pathname = name;
    }

    public String getPathname() {
        return pathname;
    }

    @JsonIgnore
    @Transient
    public List<Field> getGamePath(){
        List<Field> Standartpath = GamePath.getStandartPath();

        return Standartpath;
    }

    public List<Blockade> getBlockades(){
        List<Blockade> Blockade = GamePath.getCurrentBloacked();
        return Blockade;
    }

    public Player nextplayer(Player currentplayer){
        int i = players.indexOf(currentplayer);
        if (i == maxplayer-1){
            i = -1;
            EndGameManager endGameManager = new EndGameManager();
            if(endGameManager.CheckifReached()){
                Player winner = endGameManager.getWinner();
                return winner;



            }

        }
        players.get(i+1).setTurn(true);
        setCurrentPlayer(players.get(i+1));

        return null;
    }


    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
