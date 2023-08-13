import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        // Gameloop
        Colors.space(); // give space to game arena
        game.printOptions();
        game.askNames();

        //testing
//        game.board[0].TestAllTrue();

        while(game.turnNumber<3) {
            game.PrintCurrentPlayerBoard();

            game.printTileChoices();
            Colors.space();
            Colors.space();
        }


        game.printGameOver();
    }
}
