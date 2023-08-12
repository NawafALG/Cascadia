public class Main {
//    public static void main(String[] args) {
////        System.out.println("\u001B[31mThis text is red!\u001B[0m");
////        System.out.println("\u001B[41mThis text has a red background!\u001B[0m");
////        System.out.println(Colors.CHOSEN+"    gyjg    ");
////        Tile obj = new Tile();
////        obj.print("1,2");
////        System.out.print(obj.row1());
//
////        PrintBoard board = new PrintBoard();
////        board.init();
//
//        Game game = new Game();
////        int userChoice = game.printOptions();
////        if (userChoice == 3)
////            return; // exits
////        else if (userChoice == 2)
////            game.printHelp(); // prints help
//
//        // Gameloop
//        Colors.space(); // give space to game arena
//        game.askNames();
//
//        while(game.turnNumber<5) {
//            game.PrintCurrentPlayerBoard();
//
//            game.printTileChoices();
//        }
//
//
//        game.printGameOver();
//    }



    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', 'B', 'B', ' ', ' ', ' '},
                {'B', ' ', ' ', ' ', ' ', 'B', ' '},
                {'B', ' ', ' ', ' ', ' ', 'B', ' '},
                {'B', ' ', ' ', ' ', ' ', ' ', 'B'},
                {' ', ' ', ' ', ' ', ' ', ' ', 'B'},
                {'B', 'B', ' ', 'B', ' ', ' ', 'B'}
        };

        int pairs = calculatePairs(board);
        System.out.println("Number of 2-piece chunks: " + pairs);
    }

    public static int calculatePairs(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int pairs = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'B') {
                    int chunkSize = calculateChunkSize(board, row, col);
                    if (chunkSize == 3) {
                        pairs++;
                    }
                }
            }
        }

        return pairs;
    }

//    public static int calculateScore(char[][] board) {
//        int rows = board.length;
//        int cols = board[0].length;
//        int score = 0;
//
//        for (int row = 0; row < rows; row++) {
//            for (int col = 0; col < cols; col++) {
//                if (board[row][col] == 'B') {
//                    int chunkSize = calculateChunkSize(board, row, col);
//                    if (chunkSize >= 2) {
//                        score += calculateScoreForChunk(chunkSize);
//                    }
//                }
//            }
//        }
//
//        return score;
//    }

    public static int calculateChunkSize(char[][] board, int startRow, int startCol) {
        int rows = board.length;
        int cols = board[0].length;
        char targetChar = board[startRow][startCol];
        boolean[][] visited = new boolean[rows][cols];

        return dfs(board, visited, startRow, startCol, targetChar);
    }

    public static int dfs(char[][] board, boolean[][] visited, int row, int col, char targetChar) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != targetChar) {
            return 0;
        }

        visited[row][col] = true;

        int size = 1;
        size += dfs(board, visited, row + 1, col, targetChar);
        size += dfs(board, visited, row - 1, col, targetChar);
        size += dfs(board, visited, row, col + 1, targetChar);
        size += dfs(board, visited, row, col - 1, targetChar);

        return size;
    }
}
