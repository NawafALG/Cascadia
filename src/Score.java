public class Score {

    /*
                             1     2
                          6    tile   3
                             5     4
    */
    public static String getNeighbour(PrintBoard obj, int x, int y, int pos) {
        int displacement;
        if(x%2==0)
            displacement = 1;
        else
            displacement = 0;

        int newRow = x;
        int newCol = y;

        if (pos == 1 && newRow - 1 >= 0 && newCol - 1 + displacement >= 0) {
            newRow--;
            newCol += displacement - 1; // top left
        }

        if (pos == 2 && newRow - 1 >= 0 && newCol + displacement < obj.cols) {
            newRow--;
            newCol += displacement; // top right
        }

        if (pos == 3 && newCol + 1 < obj.cols) {
            newCol++; // right
        }

        if (pos == 4 && newRow + 1 < obj.cols && newCol + displacement < obj.cols) {
            newRow++;
            newCol += displacement; // bottom right
        }

        if (pos == 5 && newRow + 1 < obj.cols && newCol - 1 + displacement < obj.cols) {
            newRow++;
            newCol += displacement - 1; // bottom left
        }

        if (pos == 6 && newCol - 1 >= 0) {
            newCol--; // left
        }

        if (newRow == x && newCol == y) {
            return null;
        }

        if (newRow < 0 || newRow >= obj.rows || newCol < 0 || newCol >= obj.cols) {
            return null;
        }
        System.out.println("row: "+newRow);
        System.out.println("col: "+newCol);

        if (obj.obj[newRow][newCol].animaltileplaced)
            return obj.obj[newRow][newCol].animalPoolDistinct.get(obj.obj[newRow][newCol].animalSelectedIndex);
        else
            return null;
    }
    public static void getNeighbourChecked(PrintBoard obj, int x, int y, int pos) {
        int displacement;
        if(x%2==0)
            displacement = 1;
        else
            displacement = 0;

        int newRow = x;
        int newCol = y;

        if (pos == 1 && newRow - 1 >= 0 && newCol - 1 + displacement >= 0) {
            newRow--;
            newCol += displacement - 1; // top left
        }

        if (pos == 2 && newRow - 1 >= 0 && newCol + displacement < obj.cols) {
            newRow--;
            newCol += displacement; // top right
        }

        if (pos == 3 && newCol + 1 < obj.cols) {
            newCol++; // right
        }

        if (pos == 4 && newRow + 1 < obj.cols && newCol + displacement < obj.cols) {
            newRow++;
            newCol += displacement; // bottom right
        }

        if (pos == 5 && newRow + 1 < obj.cols && newCol - 1 + displacement < obj.cols) {
            newRow++;
            newCol += displacement - 1; // bottom left
        }

        if (pos == 6 && newCol - 1 >= 0) {
            newCol--; // left
        }

        if (newRow == x && newCol == y) {
            return ;
        }

        if (newRow < 0 || newRow > obj.cols || newCol < 0 || newCol > obj.cols) {
            return ;
        }

        obj.obj[newRow][newCol].checkedBool();
    }

    /*
                              1     2
                           6    tile   3
                              5     4
     */
//    public static int GetElkScore(PrintBoard board){
//        int count4 = GetElkClusters(board,  4);
//        int count3 = GetElkClusters(board,  3);
//        int count2 = GetElkClusters(board,  2);
//        int count1 = GetElkClusters(board,  1);
//
//        System.out.println("Clusters of size 4: " + count4);
//        System.out.println("Clusters of size 3: " + count3);
//        System.out.println("Clusters of size 2: " + count2);
//        System.out.println("Clusters of size 1: " + count1);
//
//
//        return 0;
//    }
//
//    public static int GetElkClusters(PrintBoard board, int clusterSize){
//        int count = 0;
//        for (int row = 0; row < board.rows; row++) {
//            for (int col = 0; col < board.cols; col++) {
//                if(board.obj[row][col].getAnimalPlaced().equals("E")) {
//                    int horizontalCount = 0;
//                    int Count2 = 0;
//                    int Count4 = 0;
//
//                    for (int i = 0; i < clusterSize; i++) {
//                        String right = getNeighbour(board, row, col, 3);
//                        if(right!= null && right.equals("E")) {
//                            if (col + i < board.cols ) {
////                            if (col + i < cols && board[row][col + i] == targetChar) {
//                                horizontalCount++;
//                            }
//                        }
//
//                        String Topright = getNeighbour(board, row, col, 2);
//                        if(Topright!= null && Topright.equals("E")) {
//                            if (row + i < board.rows ) {
//                                Count2++;
//                            }
//                        }
//
//                        String Bottomright = getNeighbour(board, row, col, 4);
//                        if(Bottomright!= null && Bottomright.equals("E")) {
//                            if (row + i < board.rows ) {
//                                Count4++;
//                            }
//                        }
//                    }
////                    if (horizontalCount == clusterSize) {
////                        for (int i = 0; i < clusterSize; i++) {
////                            board.obj[row][col + i].checkedBool();
////                        }
////                        count++;
////                    }
//                    if (horizontalCount == clusterSize) {
//                        for (int i = 0; i < clusterSize; i++) {
//                            getNeighbourChecked(board, row, col, 3);
//                        }
//                        count++;
//                    }
//                    if (Count2 == clusterSize) {
//                        for (int i = 0; i < clusterSize; i++) {
////                            board.obj[row + i][col].checkedBool();
//                            getNeighbourChecked(board, row, col, 2);
//                        }
//                        count++;
//                    }
//                    if (Count4 == clusterSize) {
//                        for (int i = 0; i < clusterSize; i++) {
////                            board.obj[row + i][col].checkedBool();
//                            getNeighbourChecked(board, row, col, 4);
//                        }
//                        count++;
//                    }
//
//                }
//            }
//        }
//        return count;
//    }
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
//                    if (horizontalCount == clusterSize) {
//                        for (int i = 0; i < clusterSize; i++) {
//                            counted[row][col + i] = true;
//                        }
//                        count++;
//                    }
//                    if (verticalCount == clusterSize) {
//                        for (int i = 0; i < clusterSize; i++) {
//                            counted[row + i][col] = true;
//                        }
//                        count++;
//                    }
//                }
//            }
//        }
//
//        return count;
//    }




    public static void GetElkScore(PrintBoard board) {
//        char[][] board = {
//                {' ', ' ', ' ', 'E', 'E', 'E', 'E'},
//                {' ', ' ', ' ', 'E', ' ', ' ', ' '},
//                {' ', ' ', ' ', 'E', ' ', ' ', ' '},
//                {' ', ' ', ' ', 'E', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '}
//        };
//        boolean[][] counted = new boolean[rows][cols];
        boolean[][] counted = new boolean[board.rows][board.cols];

        int count4 = countClusters(board, "E", 4, counted);
        int count3 = countClusters(board, "E", 3, counted);
        int count2 = countClusters(board, "E", 2, counted);
        int count1 = countClusters(board, "E", 1, counted);

        System.out.println("Clusters of size 4: " + count4);
        System.out.println("Clusters of size 3: " + count3);
        System.out.println("Clusters of size 2: " + count2);
        System.out.println("Clusters of size 1: " + count1);
    }


    public static int countClusters(PrintBoard board, String targetChar, int clusterSize, boolean[][] counted) {
        int rows = board.rows;
        int cols = board.cols;
        int count = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board.obj[row][col].getAnimalPlaced().equals(targetChar) && !counted[row][col]) {
                    int horizontalCount = 0;
                    int verticalCount = 0;

                    for (int i = 0; i < clusterSize; i++) {
                        if (col + i < cols && board.obj[row][col].getAnimalPlaced().equals(targetChar)) {
                            horizontalCount++;
                        }
                        if (row + i < rows && board.obj[row][col].getAnimalPlaced().equals(targetChar)) {
                            verticalCount++;
                        }
                    }

                    if (horizontalCount == clusterSize) {
                        for (int i = 0; i < clusterSize; i++) {
                            counted[row][col + i] = true;
                        }
                        count++;
                    }

                    if (verticalCount == clusterSize) {
                        for (int i = 0; i < clusterSize; i++) {
                            counted[row + i][col] = true;
                        }
                        count++;
                    }
                }
            }
        }
        return count;
    }




}
