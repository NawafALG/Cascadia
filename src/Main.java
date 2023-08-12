public class Main {
    public static void main(String[] args) {
//        System.out.println("\u001B[31mThis text is red!\u001B[0m");
//        System.out.println("\u001B[41mThis text has a red background!\u001B[0m");

//        Tile obj = new Tile();
//        obj.print("1,2");
//        System.out.print(obj.row1());

//        PrintBoard board = new PrintBoard();
//        board.init();

        Game game = new Game();
        game.startGame();

        game.printTileChoices();
    }
}
