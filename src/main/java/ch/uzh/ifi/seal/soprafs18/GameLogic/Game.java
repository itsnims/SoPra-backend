package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.Constant.GameStatus;
import ch.uzh.ifi.seal.soprafs18.Entity.User;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Tile;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.ElDorado;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @Column(unique=true)
    String name;

    @Column
    String owner;

    @Column
    int maxplayer;

    @Column
    GameStatus gameStatus;

    @JsonIgnore
    @Transient
    public List<Player> Players = new ArrayList<>(4);

    @JsonIgnore
    @Transient
    public int roundNum=0;


    @Transient
    private int i;

    @Transient
    private  Player winner;

    @OneToMany
    List<User> users = new ArrayList<>();

    @Column
    int current;



    public Game(){}
    public Game(String name){

        Field A1 = new Field(0,"Green",false,false,true);
        Field A2 = new Field(0,"Green",false,false,true);
        Field A3 = new Field(0,"Green",false,false,true);
        Field A4 = new Field(0,"Green",false,false,true);
        Field A5 = new Field(1,"Green",false,false,true);
        Field A6 = new Field(1,"Green",false,false,true);
        Field A7 = new Field(1,"Green",false,false,true);
        Field A8 = new Field(1,"Green",false,false,true);
        Field A9 = new Field(1,"Green",false,false,true);
        Field A10 = new Field(1,"Green",false,false,true);
        Field A11 = new Field(1,"Green",false,false,true);
        Field A12 = new Field(1,"Yellow",false,false,true);
        Field A13 = new Field(1,"Green",false,false,true);
        Field A14 = new Field(1,"Blue",false,false,true);
        Field A15 = new Field(1,"Green",false,false,true);
        Field A16 = new Field(1,"Green",false,false,true);
        Field A17 = new Field(1,"Yellow",false,false,true);
        Field A18 = new Field(1,"Green",false,false,true);
        Field A19 = new Field(1,"Blue",false,false,true);
        Field A20 = new Field(1,"Green",false,false,true);
        Field A21 = new Field(1,"Yellow",false,false,true);
        Field A22 = new Field(1,"Green",false,false,true);
        Field A23 = new Field(1,"Green",false,false,true);
        Field A24 = new Field(0,"Cave",false,false,false);
        Field A25 = new Field(1,"Yellow",false,false,true);
        Field A26 = new Field(1,"Green",false,false,true);
        Field A27 = new Field(1,"Green",false,false,true);
        Field A28 = new Field(1,"Green",false,false,true);
        Field A29 = new Field(1,"Blue",false,false,true);
        Field A30 = new Field(1,"Cave",false,false,false);
        Field A31 = new Field(1,"Green",false,false,true);
        Field A32 = new Field(1,"Green",false,false,true);
        Field A33 = new Field(1,"Yellow",false,false,true);
        Field A34 = new Field(1,"Green",false,false,true);
        Field A35 = new Field(1,"Red",true,true,true);
        Field A36 = new Field(1,"Green",false,false,true);
        Field A37 = new Field(1,"Green",false,false,true);
        A1.AddNewNeighbour(A2,A5,A6);
        A2.AddNewNeighbour(A1,A6,A7,A3);
        A3.AddNewNeighbour(A2,A7,A8,A4);
        A4.AddNewNeighbour(A3,A8,A9);
        A5.AddNewNeighbour(A1,A6,A10,A11);
        A6.AddNewNeighbour(A1,A2,A7,A12,A11,A5);
        A7.AddNewNeighbour(A2,A3,A8,A13,A12,A6);
        A8.AddNewNeighbour(A3,A4,A9,A14,A13,A7);
        A9.AddNewNeighbour(A4,A15,A14,A8);
        A10.AddNewNeighbour(A5,A11,A17,A16);
        A11.AddNewNeighbour(A5,A6,A12,A18,A17,A10);
        A12.AddNewNeighbour(A6,A7,A13,A19,A18,A11);
        A13.AddNewNeighbour(A7,A8,A14,A20,A19,A12);
        A14.AddNewNeighbour(A8,A9,A15,A21,A20,A13);
        A15.AddNewNeighbour(A9,A22,A21,A14);
        A16.AddNewNeighbour(A10,A17,A23);
        A17.AddNewNeighbour(A10,A11,A18,A24,A23,A16);
        A18.AddNewNeighbour(A11,A12,A19,A25,A24,A17);
        A19.AddNewNeighbour(A12,A13,A20,A26,A25,A18);
        A20.AddNewNeighbour(A13,A14,A21,A27,A26,A19);
        A21.AddNewNeighbour(A14,A15,A22,A28,A27,A20);
        A22.AddNewNeighbour(A15,A28,A21);
        A23.AddNewNeighbour(A16,A17,A24,A29);
        A24.AddNewNeighbour(A17,A18,A25,A30,A29,A23);
        A25.AddNewNeighbour(A18,A19,A26,A31,A30,A24);
        A26.AddNewNeighbour(A19,A20,A27,A32,A32,A25);
        A27.AddNewNeighbour(A20,A21,A28,A33,A32,A26);
        A28.AddNewNeighbour(A21,A22,A33,A27);
        A29.AddNewNeighbour(A23,A24,A30,A34);
        A30.AddNewNeighbour(A24,A25,A31,A35,A34,A29);
        A31.AddNewNeighbour(A25,A26,A32,A36,A35,A30);
        A32.AddNewNeighbour(A26,A27,A33,A37,A36,A31);
        A33.AddNewNeighbour(A27,A28,A37,A32);
        A34.AddNewNeighbour(A29,A30,A35);
        A35.AddNewNeighbour(A34,A30,A31,A36);
        A36.AddNewNeighbour(A35,A31,A32,A37);
        A37.AddNewNeighbour(A36,A32,A33);



    }

    public void addPlayer(Player player){ Players.add(player); }

    public Player round(){
        while(! new EndGameManager().CheckifReached()) {

            for (i = 0; i < Players.size(); i++) {
                Players.get(i).setTurn(true);
                while (Players.get(i).getTurn() && Players.get(i).handcards.size() > 0) {
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

    public Player getPlayer(int index){
        return Players.get(0);
    }

    @Transient
    @JsonIgnore
    public int getNumFigures(){
        return Players.size();
    }

    public Long getId() {
        return id;
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


    public void addUser(User user){
        users.add(user);
        current ++;


    }

    public int getCurrent() {
        return current;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public List<User> getUsers() {
        return users;
    }

    public void deleteUser(User user){
        users.remove(user);
        System.out.println(user);
        current --;
    }
}
