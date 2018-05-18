package ch.uzh.ifi.seal.soprafs18.GameLogic;
import java.util.List;

public class EndGameManager  {
    private Player Winner;
    private int  j;
    private Player k;

    private Game game;

    public EndGameManager(Game game){
        this.game = game;

    }

   public boolean checkifReached(){
       boolean isWon= false;
       Integer playerSize= game.players.size();
       List<Player> winners = game.getWinners();
       if (playerSize.equals(2)){
           Player first = game.players.get(0);
           Player second = game.players.get(1);
           if (winners.contains(first)){
               System.out.println("Im at winner");
               String oneP= first.getMyFigures().get(0).getCurrentPosition().getName();
               String twoP = first.getMyFigures().get(1).getCurrentPosition().getName();
               if (oneP == "EDBlue1" || oneP=="EDBlue2"|| oneP== "EDBlue3" ||
                       oneP == "EDGreen1" || oneP=="EDGreen2"|| oneP== "EDGreen3"){
                   System.out.println("First is in eldorado");
                   System.out.println("this is the twop"+twoP);
                   if (twoP == "EDBlue1" || twoP=="EDBlue2"|| twoP== "EDBlue3" ||
                           twoP == "EDGreen1" || twoP=="EDGreen2"|| twoP== "EDGreen3"){
                       isWon=true;
                       System.out.println("Second is in eldorado");
                       System.out.println("this is win at second" + isWon);
                   }}}

                   if(winners.contains(second)){
               String onePi=second.getMyFigures().get(0).getCurrentPosition().getName();
               String twoPi=second.getMyFigures().get(1).getCurrentPosition().getName();
               if (onePi == "EDBlue1" || onePi=="EDBlue2"|| onePi== "EDBlue3" ||
                       onePi == "EDGreen1" || onePi=="EDGreen2"|| onePi== "EDGreen3"){
                   if (twoPi == "EDBlue1" || twoPi == "EDBlue2" || twoPi == "EDBlue3" ||
                           twoPi == "EDGreen1" || twoPi == "EDGreen2" || twoPi == "EDGreen3") {
                       isWon = true;
                   }}}




       } else if (playerSize > 2){
           if (game.getWinners().size() > 0){
               isWon=true; }
       }
       System.out.println("this is win at end" + isWon);

       return isWon;


   }



    public void getWinner(){
        if (game.players.size() == 2){
            Player first = game.players.get(0);
            Player second = game.players.get(1);
            boolean firstHasBoth= false;
            boolean secondHasBoth=false;
            if (game.getWinners().contains(first)){
                String oneP= first.getMyFigures().get(0).getCurrentPosition().getName();
                String twoP = first.getMyFigures().get(1).getCurrentPosition().getName();
                if (oneP == "EDBlue1" || oneP=="EDBlue2"|| oneP== "EDBlue3" ||
                        oneP == "EDGreen1" || oneP=="EDGreen2"|| oneP== "EDGreen3"){
                    if (twoP == "EDBlue1" || twoP=="EDBlue2"|| twoP== "EDBlue3" ||
                            twoP == "EDGreen1" || twoP=="EDGreen2"|| twoP== "EDGreen3"){game.setWinner(first); firstHasBoth=true;
                    }}}
                    if(game.getWinners().contains(second)){
                String onePi=second.getMyFigures().get(0).getCurrentPosition().getName();
                String twoPi=second.getMyFigures().get(1).getCurrentPosition().getName();
                if (onePi == "EDBlue1" || onePi=="EDBlue2"|| onePi== "EDBlue3" ||
                        onePi == "EDGreen1" || onePi=="EDGreen2"|| onePi== "EDGreen3"){
                    if (twoPi == "EDBlue1" || twoPi == "EDBlue2" || twoPi == "EDBlue3" ||
                            twoPi == "EDGreen1" || twoPi == "EDGreen2" || twoPi == "EDGreen3") {
                        game.setWinner(second); secondHasBoth=true;
                    }}}
                    if (firstHasBoth && secondHasBoth){
                if (first.getBlockadePoints() > second.getBlockadePoints()){game.setWinner(first);}
                else {game.setWinner(second);}
            }


        }else if (game.players.size()>2){
            if (game.getWinners().size() == 1) {
            Winner = game.getWinners().get(0);
            game.setWinner(Winner);
           } else if (game.getWinners().size() > 1) {
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



}
