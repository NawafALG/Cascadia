import java.util.ArrayList;
import java.util.HashSet;

public class Score {

    /*
                             1     2
                          6    tile   3
                             5     4
    */
    public static int calculateSpace(int col,int y) {
        if (y % 2 != 0){
            if (col % 2 == 1) return 0;
            return 1;
        }
        else if(y%2 == 0){
            if (col % 2 == 1) return 0;
        }
        return 1;
    }
    public static String getNeighbour(PrintBoard obj, int x, int y, int pos) {
        int displacement= calculateSpace(x,y);

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
//        System.out.println("row: "+newRow);
//        System.out.println("col: "+newCol);

        if (obj.obj[newRow][newCol].animaltileplaced)
            return obj.obj[newRow][newCol].animalPoolDistinct.get(obj.obj[newRow][newCol].animalSelectedIndex);
        else
            return " ";
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

    public static String scoretest(PrintBoard obj, int x, int y, int pos){
        int displacement= calculateSpace(x,y);

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
//        System.out.println("row: "+newRow);
//        System.out.println("col: "+newCol);

        return null;

    }

    private static int HabitatnextX(PrintBoard obj, int x, int y, int pos){
        int displacement= calculateSpace(x,y);

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

//        if (newRow == x && newCol == y) {
//            return null;
//        }
//
//        if (newRow < 0 || newRow >= obj.rows || newCol < 0 || newCol >= obj.cols) {
//            return null;
//        }

        return newRow;
    }
    private static int HabitatnextY(PrintBoard obj, int x, int y, int pos){
        int displacement= calculateSpace(x,y);

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
//        if (newRow == x && newCol == y) {
//            return null;
//        }
//
//        if (newRow < 0 || newRow >= obj.rows || newCol < 0 || newCol >= obj.cols) {
//            return null;
//        }
        return newCol;
    }

    /*
                              1     2
                           6    tile   3
                              5     4
     */
    public static int GetElkScore(PrintBoard board){
        int count4 = GetElkClusters(board,  4);
        int count3 = GetElkClusters(board,  3);
        int count2 = GetElkClusters(board,  2);
        int count1 = GetElkClusters(board,  1);


        return (13*count4) + (9*count3) + (5*count2) + (2*count1);
    }
//
    public static int GetElkClusters(PrintBoard board, int clusterSize){
        int count = 0;
        for (int row = 0; row < board.rows; row++) {
            for (int col = 0; col < board.cols; col++) {
                if(board.obj[row][col].getAnimalPlaced().equals("E")) {
                    int horizontalCount = 0;
                    int Count2 = 0;
                    int Count4 = 0;

                    for (int i = 0; i < clusterSize; i++) {
                        String right = getNeighbour(board, row, col, 3);
                        if(right!= null && right.equals("E")) {
                            if (col + i < board.cols ) {
//                            if (col + i < cols && board[row][col + i] == targetChar) {
                                horizontalCount++;
                            }
                        }

                        String Topright = getNeighbour(board, row, col, 2);
                        if(Topright!= null && Topright.equals("E")) {
                            if (row + i < board.rows ) {
                                Count2++;
                            }
                        }

                        String Bottomright = getNeighbour(board, row, col, 4);
                        if(Bottomright!= null && Bottomright.equals("E")) {
                            if (row + i < board.rows ) {
                                Count4++;
                            }
                        }
                    }
//                    if (horizontalCount == clusterSize) {
//                        for (int i = 0; i < clusterSize; i++) {
//                            board.obj[row][col + i].checkedBool();
//                        }
//                        count++;
//                    }
                    if (horizontalCount == clusterSize) {
                        for (int i = 0; i < clusterSize; i++) {
                            getNeighbourChecked(board, row, col, 3);
                        }
                        count++;
                    }
                    if (Count2 == clusterSize) {
                        for (int i = 0; i < clusterSize; i++) {
//                            board.obj[row + i][col].checkedBool();
                            getNeighbourChecked(board, row, col, 2);
                        }
                        count++;
                    }
                    if (Count4 == clusterSize) {
                        for (int i = 0; i < clusterSize; i++) {
//                            board.obj[row + i][col].checkedBool();
                            getNeighbourChecked(board, row, col, 4);
                        }
                        count++;
                    }

                }
            }
        }
        return count;
    }
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




//    public static void GetElkScore(PrintBoard board) {
////        char[][] board = {
////                {' ', ' ', ' ', 'E', 'E', 'E', 'E'},
////                {' ', ' ', ' ', 'E', ' ', ' ', ' '},
////                {' ', ' ', ' ', 'E', ' ', ' ', ' '},
////                {' ', ' ', ' ', 'E', ' ', ' ', ' '},
////                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
////                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
////                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
////                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
////                {' ', ' ', ' ', ' ', ' ', ' ', ' '}
////        };
////        boolean[][] counted = new boolean[rows][cols];
//        boolean[][] counted = new boolean[board.rows][board.cols];
//
//        int count4 = countClusters(board, "E", 4, counted);
//        int count3 = countClusters(board, "E", 3, counted);
//        int count2 = countClusters(board, "E", 2, counted);
//        int count1 = countClusters(board, "E", 1, counted);
//
//        System.out.println("Clusters of size 4: " + count4);
//        System.out.println("Clusters of size 3: " + count3);
//        System.out.println("Clusters of size 2: " + count2);
//        System.out.println("Clusters of size 1: " + count1);
//    }


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

    // hawk
    public static int GetHawkScore(PrintBoard board){
        int hawkscore = 0;
        for (int row = 0; row < board.rows; row++) {
            for (int col = 0; col < board.cols; col++) {
                if(board.obj[row][col].getAnimalPlaced().equals("H")){
                    int counter = 0;
                    for(int j=1;j<=6;j++){
                        String  tempval = getNeighbour(board, row, col, j);
                        if(tempval == null || !getNeighbour(board, row, col, j).equals("H")){
                            counter++;
                        }
                    }
                    if(counter == 6){
                        hawkscore++;
                    }
                }
            }
        }


//        if(hawkscore == 1)
//            hawkscore = 2;
//        else if (hawkscore == 2)
//            hawkscore = 5;
//        else if (hawkscore == 3)
//            hawkscore = 8;
//        else if (hawkscore == 4)
//            hawkscore = 11;
//        else if (hawkscore == 5)
//            hawkscore = 14;
//        else if (hawkscore == 6)
//            hawkscore = 18;
//        else if (hawkscore == 7)
//            hawkscore = 22;
//        else if (hawkscore >= 8)
//            hawkscore = 26;
//
        return hawkscore;
    }
    // Foxes
    public static int GetFoxScore(PrintBoard board){
        int foxscore = 0;

        for (int row = 0; row < board.rows; row++) {
            for (int col = 0; col < board.cols; col++) {
                if(board.obj[row][col].getAnimalPlaced().equals("F")){
                    ArrayList<String> neighbouringAnimals = new ArrayList<>();
                    for(int j=1;j<=6;j++){
                        String tempval = getNeighbour(board, row, col, j);
                        if ( tempval != null && !tempval.equals(" "))
                            neighbouringAnimals.add(getNeighbour(board, row, col, j));
                    }
                    foxscore += countUniqueChars(neighbouringAnimals);
                }
            }
        }

//        if(foxscore == 1)
//            foxscore = 1;
//        else if (foxscore == 2)
//            foxscore = 2;
//        else if (foxscore == 3)
//            foxscore = 3;
//        else if (foxscore == 4)
//            foxscore = 4;
//        else if (foxscore == 5)
//            foxscore = 5;
        
        return foxscore;
    }
    private static int countUniqueChars(ArrayList<String> list) {
        HashSet<String> uniqueChars = new HashSet<>();

        for (String c : list) {
            uniqueChars.add(c);
        }
        return uniqueChars.size();
    }

    // salmon
    public static int GetSalmonScore(PrintBoard board){
        int rows = board.rows;
        int cols = board.cols;
        int count = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board.obj[row][col].getAnimalPlaced().equals("S")) {
                    int[][] visited = new int[rows][cols];
                    if (dfs(board, row, col, visited, 1)) {
                        count++;
                    }
                }
            }
        }
//        if(count == 1)
//            count = 2;
//        else if (count == 2)
//            count = 5;
//        else if (count == 3)
//            count = 8;
//        else if (count == 4)
//            count = 12;
//        else if (count == 5)
//            count = 16;
//        else if (count == 6)
//            count = 20;
//        else if (count == 7)
//            count = 25;
        
        return count;
    }
    public static boolean dfs(PrintBoard board, int row, int col, int[][] visited, int length) {
        if (row < 0 || row >= board.rows || col < 0 || col >= board.cols || visited[row][col] > 2) {
            return false;
        }
        if (board.obj[row][col].getAnimalPlaced().equals("S")) {
            visited[row][col]++;
            if (length == 3) {
                return true;
            }
            // Check all 6 neighbors
            int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 0}, {1, -1}, {0, -1}};
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (dfs(board, newRow, newCol, visited, length + 1)) {
                    return true;
                }
            }
            visited[row][col]--;
        }
        return false;
    }
    public static int GetBearScore(PrintBoard obj) {
        float score = 0;

        for (int row = 0; row < obj.rows; row++) {
            for (int col = 0; col < obj.cols; col++) {
                if (obj.obj[row][col].getAnimalPlaced().equals("B")) {
                    int chunkSize = calculateBearChunkSize(obj, row, col);
                    if (chunkSize >= 2) {
                        if (chunkSize == 2) {
                            score += 0.5;
                        }
                    }
                }
            }
        }

        return (int)score;
    }
    public static int calculateBearChunkSize(PrintBoard obj, int startRow, int startCol) {
        int rows = obj.rows;
        int cols = obj.cols;
//        String targetChar = obj.obj[startRow][startCol].animalPoolDistinct.get(obj.obj[startRow][startCol].animalSelectedIndex);
        boolean[][] visited = new boolean[rows][cols];

        return SubFuncBearDfs(obj, visited, startRow, startCol, "B");
    }
    public static int SubFuncBearDfs( PrintBoard obj, boolean[][] visited, int row, int col, String targetChar) {
        if (row < 0 || row >= obj.rows || col < 0 || col >= obj.cols || visited[row][col] || !obj.obj[row][col].animalPoolDistinct.get(obj.obj[row][col].animalSelectedIndex).equals(targetChar)) {
            return 0;
        }

        visited[row][col] = true;

        int size = 1;
        size += SubFuncBearDfs(obj, visited, HabitatnextX(obj, row, col, 1), HabitatnextY(obj, row, col, 1), targetChar);
        size += SubFuncBearDfs(obj, visited, HabitatnextX(obj, row, col, 2), HabitatnextY(obj, row, col, 2), targetChar);
        size += SubFuncBearDfs(obj, visited, HabitatnextX(obj, row, col, 3), HabitatnextY(obj, row, col, 3), targetChar);
        size += SubFuncBearDfs(obj, visited, HabitatnextX(obj, row, col, 4), HabitatnextY(obj, row, col, 4), targetChar);
        size += SubFuncBearDfs(obj, visited, HabitatnextX(obj, row, col, 5), HabitatnextY(obj, row, col, 5), targetChar);
        size += SubFuncBearDfs(obj, visited, HabitatnextX(obj, row, col, 6), HabitatnextY(obj, row, col, 6), targetChar);

        return size;
    }




    public static int GetMaxHabitatChunkSize(PrintBoard board, String Habitat){
        int rows = board.rows;
        int cols = board.cols;
        int largestChunkSize = 0;

        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (( board.obj[row][col].upinfo.equals(Habitat)  || ( board.obj[row][col].downinfo.equals(Habitat) ) && !visited[row][col])) {
                    int chunkSize = Habitatdfs(board, visited, row, col, Habitat);
                    largestChunkSize = Math.max(largestChunkSize, chunkSize);
                }
            }
        }
        return largestChunkSize;
    }
    public static int Habitatdfs(PrintBoard board, boolean[][] visited, int row, int col, String targetChar) {
        if (row < 0 || row >= board.rows || col < 0 || col >= board.cols || visited[row][col] || !( board.obj[row][col].upinfo.equals(targetChar)  || ( board.obj[row][col].downinfo.equals(targetChar)  ) )) {
            return 0;
        }
        visited[row][col] = true;
        int size = 1;
        size += Habitatdfs(board, visited, HabitatnextX(board, row, col, 1), HabitatnextY(board, row, col, 1), targetChar);
        size += Habitatdfs(board, visited, HabitatnextX(board, row, col, 2), HabitatnextY(board, row, col, 2), targetChar);
        size += Habitatdfs(board, visited, HabitatnextX(board, row, col, 3), HabitatnextY(board, row, col, 3), targetChar);
        size += Habitatdfs(board, visited, HabitatnextX(board, row, col, 4), HabitatnextY(board, row, col, 4), targetChar);
        size += Habitatdfs(board, visited, HabitatnextX(board, row, col, 5), HabitatnextY(board, row, col, 5), targetChar);
        size += Habitatdfs(board, visited, HabitatnextX(board, row, col, 6), HabitatnextY(board, row, col, 6), targetChar);

        return size;
    }

}
