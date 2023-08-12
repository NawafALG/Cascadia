public class Main {
    public static void main(String[] args) {
//        System.out.println("\u001B[31mThis text is red!\u001B[0m");
//        System.out.println("\u001B[41mThis text has a red background!\u001B[0m");
//        System.out.println(Colors.CHOSEN+"    gyjg    ");
//        Tile obj = new Tile();
//        obj.print("1,2");
//        System.out.print(obj.row1());

//        PrintBoard board = new PrintBoard();
//        board.init();

        Game game = new Game();
        int userChoice = game.printOptions();
        if (userChoice == 3)
            return; // exits
        else if (userChoice == 2)
            game.printHelp(); // prints help

        // Gameloop
        Colors.space(); // give space to game arena
        game.askNames();


        game.PrintCurrentPlayerBoard();

        game.printTileChoices();

    }
}
