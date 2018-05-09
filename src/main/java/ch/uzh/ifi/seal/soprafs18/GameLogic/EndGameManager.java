package ch.uzh.ifi.seal.soprafs18.GameLogic;

public class EndGameManager  {
    private Player Winner;
    private int  j;
    private Player k;

    private Game game;

    public EndGameManager(Game game){
        this.game = game;

    }

    public boolean checkifReached(){
        if(game.getWinners().size() == 0){
            return false;
        }
        else{
            return true;
        }

    }



    public void getWinner(){
        if (game.getWinners().size() == 1) {
            Winner = game.getWinners().get(0);
            game.setWinner(Winner);
        }
        else if (game.getWinners().size() > 1) {
            k= game.getWinners().get(0);
            for(j=0;j<game.getWinners().size();j++){
                if(k.getBlockadePoints()< game.getWinners().get(j).getBlockadePoints()){
                    k= game.getWinners().get(j);
                }
            }

            game.setWinner(k);
        }

    }



}
