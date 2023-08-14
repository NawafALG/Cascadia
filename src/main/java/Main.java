import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        // Gameloop
        Colors.space(); // give space to game arena
        if(game.printOptions()==2){
            game.printHelp();
        }
        Colors.space();
        game.askNames();

        while(game.turnNumber<40) {
            game.PrintCurrentPlayerBoard();
            game.printTileChoices();
            Colors.space();
        }
        game.printGameOver();
    }
}
