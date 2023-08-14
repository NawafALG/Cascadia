import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        // Gameloop
//        Colors.space(); // give space to game arena
//        game.printOptions();
//        game.askNames();

        //testing
        game.board[0].TestAllTrue();
        game.board[0].TestAnimalsPlaced();

//        while(game.turnNumber<3) {
            game.PrintCurrentPlayerBoard();
//
//            game.printTileChoices();
//            Colors.space();
//            Colors.space();
//        }

//        Score.GetMaxHabitatChunkSize(game.board[0],"RIVER");
//        game.printGameOver();
        game.printScoreBoard();
    }
}
