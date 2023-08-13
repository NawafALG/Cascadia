import java.util.Scanner;

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
//        int userChoice = game.printOptions();
//        if (userChoice == 3)
//            return; // exits
//        else if (userChoice == 2)
//            game.printHelp(); // prints help

        // Gameloop
        Colors.space(); // give space to game arena
        game.askNames();

        //testing
        game.board[0].TestAllTrue();

        while(game.turnNumber<5) {
            game.PrintCurrentPlayerBoard();

//            Scanner scanner = new Scanner(System.in);
//            while(true){
//                System.out.print("\nx: ");
//                int x = scanner.nextInt();
//
//                System.out.print("y: ");
//                int y = scanner.nextInt();
//
//                for(int i=1;i<=6;i++) {
//                    System.out.print("\ni: "+i+"\n");
//                    Score.scoretest(game.board[0], x - 1, y - 1, i);
//
//                }
//            }

            game.printTileChoices();


            Colors.space();
            Score.GetHawkScore(game.board[0]);
            Colors.space();
        }


        game.printGameOver();
    }

//    public static void main(String[] args) {
//        char[][] board = {
//                {' ', ' ', ' ', 'E', 'E', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '}
//        };
////        boolean[][] counted = new boolean[rows][cols];
//        boolean[][] counted = new boolean[board.length][board[0].length];
//
//        int count4 = countClusters(board, 'E', 4, counted);
//        int count3 = countClusters(board, 'E', 3, counted);
//        int count2 = countClusters(board, 'E', 2, counted);
//
//        System.out.println("Clusters of size 4: " + count4);
//        System.out.println("Clusters of size 3: " + count3);
//        System.out.println("Clusters of size 2: " + count2);
//    }
//
//
//    public static int countClusters(char[][] board, char targetChar, int clusterSize, boolean[][] counted) {
//        int rows = board.length;
//        int cols = board[0].length;
//        int count = 0;
//
//        for (int row = 0; row < rows; row++) {
//            for (int col = 0; col < cols; col++) {
//                if (board[row][col] == targetChar && !counted[row][col]) {
//                    int horizontalCount = 0;
//                    int verticalCount = 0;
//
//                    for (int i = 0; i < clusterSize; i++) {
//                        if (col + i < cols && board[row][col + i] == targetChar) {
//                            horizontalCount++;
//                        }
//                        if (row + i < rows && board[row + i][col] == targetChar) {
//                            verticalCount++;
//                        }
//                    }
//
//                    if (horizontalCount == clusterSize) {
//                        for (int i = 0; i < clusterSize; i++) {
//                            counted[row][col + i] = true;
//                        }
//                        count++;
//                    }
//
//                    if (verticalCount == clusterSize) {
//                        for (int i = 0; i < clusterSize; i++) {
//                            counted[row + i][col] = true;
//                        }
//                        count++;
//                    }
//                }
//            }
//        }
//        return count;
//    }
}
