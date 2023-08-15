import java.util.Scanner;

import static java.time.Clock.system;
public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        // Gameloop
        Colors.space(); // give space to game arena

//        while(game.printOptions() == 2){
//            game.printHelp();
//        }

        game.printOptions();

        Colors.space();
        game.askNames();
        game.setturnnumber();

        while(game.turnNumber<game.maximumTurns) {
            game.PrintCurrentPlayerBoard();
            game.printTileChoices();
            Colors.space();
        }
        game.printGameOver();
    }
}

// thats all
// good to see you !
