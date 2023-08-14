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



    private static boolean elkcounted[][];
    private static boolean Elkvalidtopright(PrintBoard board,int clusterSize, int x, int y){
        boolean found = false;
        if(!board.obj[x][y].getAnimalPlaced().equals("E"))
            return false;

        int trX=x, trY=y, count=1;
        for(int i=0;i<clusterSize-1;i++){
            trX = HabitatnextX(board, trX, trY, 2);
            trY = HabitatnextY(board, trX, trY, 2);
            if(trX >= 0 && trX < board.rows && trY >= 0 && trY< board.cols && getNeighbour(board, trX, trY, 2)!=null && getNeighbour(board, trX, trY, 2).equals("E") && elkcounted[trX][trY]==false){
                count++;
            }
            else{
                break;
            }
        }
        if(count==clusterSize)
            found=true;

        return found;
    }
    private static boolean Elkvalidright(PrintBoard board,int clusterSize, int x, int y){
        boolean found = false;
        if(!board.obj[x][y].getAnimalPlaced().equals("E"))
            return false;

        int trX=x, trY=y, count=1;
        for(int i=0;i<clusterSize-1;i++){
            trX = HabitatnextX(board, trX, trY, 3);
            trY = HabitatnextY(board, trX, trY, 3);
            if(trX >= 0 && trX < board.rows && trY >= 0 && trY< board.cols && getNeighbour(board, trX, trY, 3)!=null && getNeighbour(board, trX, trY, 3).equals("E") && elkcounted[trX][trY]==false){
                count++;
            }
            else{
                break;
            }
        }
        if(count==clusterSize)
            found=true;

        return found;
    }
    private static boolean Elkvalidbottomright(PrintBoard board,int clusterSize, int x, int y){
        boolean found = false;
        if(!board.obj[x][y].getAnimalPlaced().equals("E"))
            return false;

        int trX=x, trY=y, count=1;
        for(int i=0;i<clusterSize-1;i++){
            trX = HabitatnextX(board, trX, trY, 4);
            trY = HabitatnextY(board, trX, trY, 4);
            if(trX >= 0 && trX < board.rows && trY >= 0 && trY< board.cols && getNeighbour(board, trX, trY, 4)!=null && getNeighbour(board, trX, trY, 4).equals("E") && elkcounted[trX][trY]==false){
                count++;
            }
            else{
                break;
            }
        }
        if(count==clusterSize)
            found=true;

        return found;
    }
    public static int GetElkClusters(PrintBoard board, int clusterSize){
        int count = 0;
        for (int row = 0; row < board.rows; row++) {
            for (int col = 0; col < board.cols; col++) {
                if(board.obj[row][col].getAnimalPlaced().equals("E") ) {
                    int horizontalCount = 0;
                    int Count2 = 0;
                    int Count4 = 0;

                    if(Elkvalidtopright(board,clusterSize, row,col)){
                        elkcounted[row][col] = true;
                        int trX=row, trY=col;
                        for(int i = 0 ;i<clusterSize-1;i++){
                            trX = HabitatnextX(board, trX, trY, 2);
                            trY = HabitatnextY(board, trX, trY, 2);
                            elkcounted[trX][trY] = true;
                        }
                        count++;
                    }
                    if(Elkvalidright(board,clusterSize, row,col)){
                        elkcounted[row][col] = true;
                        int trX=row, trY=col;
                        for(int i = 0 ;i<clusterSize-1;i++){
                            trX = HabitatnextX(board, trX, trY, 3);
                            trY = HabitatnextY(board, trX, trY, 3);
                            elkcounted[trX][trY] = true;
                        }
                        count++;
                    }
                    if(Elkvalidbottomright(board,clusterSize, row,col)){
                        elkcounted[row][col] = true;
                        int trX=row, trY=col;
                        for(int i = 0 ;i<clusterSize-1;i++){
                            trX = HabitatnextX(board, trX, trY, 4);
                            trY = HabitatnextY(board, trX, trY, 4);
                            elkcounted[trX][trY] = true;
                        }
                        count++;
                    }

                }
            }
        }

        return count;
    }

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




    public static int GetElkScore(PrintBoard board) {

        elkcounted = new boolean[board.rows][board.cols];

        int count4 = GetElkClusters(board,  4);
        int count3 = GetElkClusters(board,  3);
        int count2 = GetElkClusters(board,  2);
        int count1 = GetElkClusters(board,  1);

        return (13*count4) + (9*count3) + (5*count2) + (2*(count1/3));

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


        if(hawkscore == 1)
            hawkscore = 2;
        else if (hawkscore == 2)
            hawkscore = 5;
        else if (hawkscore == 3)
            hawkscore = 8;
        else if (hawkscore == 4)
            hawkscore = 11;
        else if (hawkscore == 5)
            hawkscore = 14;
        else if (hawkscore == 6)
            hawkscore = 18;
        else if (hawkscore == 7)
            hawkscore = 22;
        else if (hawkscore >= 8)
            hawkscore = 26;

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

        if(foxscore == 1)
            foxscore = 1;
        else if (foxscore == 2)
            foxscore = 2;
        else if (foxscore == 3)
            foxscore = 3;
        else if (foxscore == 4)
            foxscore = 4;
        else if (foxscore == 5)
            foxscore = 5;
        
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

        float score = 0;

        for (int row = 0; row < board.rows; row++) {
            for (int col = 0; col < board.cols; col++) {
                if (board.obj[row][col].getAnimalPlaced().equals("S")) {
                    int chunkSize = calculateSalmonChunkSize(board, row, col);
                    if (chunkSize >= 2) {
                        if (chunkSize == 1) {
                            score += 2;
                        }
                        if (chunkSize == 2) {
                            score += 5/2;
                        }
                        if (chunkSize == 3) {
                            score += 8/3;
                        }
                        if (chunkSize == 4) {
                            score += 12/4;
                        }
                        if (chunkSize == 5) {
                            score += 16/5;
                        }
                        if (chunkSize == 6) {
                            score += 20/6;
                        }
                        if (chunkSize >= 7) {
                            score += 25/7;
                        }
                    }
                }
            }
        }

        return (int)Math.round(score);
    }
    public static int calculateSalmonChunkSize(PrintBoard obj, int startRow, int startCol) {
        int rows = obj.rows;
        int cols = obj.cols;
//        String targetChar = obj.obj[startRow][startCol].animalPoolDistinct.get(obj.obj[startRow][startCol].animalSelectedIndex);
        boolean[][] visited = new boolean[rows][cols];

        return SubFuncSalmonDfs(obj, visited, startRow, startCol, "S");
    }
    public static int SubFuncSalmonDfs( PrintBoard obj, boolean[][] visited, int row, int col, String targetChar) {
        if (row < 0 || row >= obj.rows || col < 0 || col >= obj.cols || visited[row][col] || !obj.obj[row][col].animalPoolDistinct.get(obj.obj[row][col].animalSelectedIndex).equals(targetChar)) {
            return 0;
        }
        visited[row][col] = true;
        int size = 1;
        size += SubFuncSalmonDfs(obj, visited, HabitatnextX(obj, row, col, 1), HabitatnextY(obj, row, col, 1), targetChar);
        size += SubFuncSalmonDfs(obj, visited, HabitatnextX(obj, row, col, 2), HabitatnextY(obj, row, col, 2), targetChar);
        size += SubFuncSalmonDfs(obj, visited, HabitatnextX(obj, row, col, 3), HabitatnextY(obj, row, col, 3), targetChar);
        size += SubFuncSalmonDfs(obj, visited, HabitatnextX(obj, row, col, 4), HabitatnextY(obj, row, col, 4), targetChar);
        size += SubFuncSalmonDfs(obj, visited, HabitatnextX(obj, row, col, 5), HabitatnextY(obj, row, col, 5), targetChar);
        size += SubFuncSalmonDfs(obj, visited, HabitatnextX(obj, row, col, 6), HabitatnextY(obj, row, col, 6), targetChar);

        return size;
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
                int chunkSize;
                if (( board.obj[row][col].upinfo.equals(Habitat) && !visited[row][col])) {
                    chunkSize = Habitatdfs(board, visited, row, col, Habitat, 1);
                    largestChunkSize = Math.max(largestChunkSize, chunkSize);
                }
                if (( board.obj[row][col].upinfo.equals(Habitat) && !visited[row][col])) {
                    chunkSize = Habitatdfs(board, visited, row, col, Habitat, 2);
                    largestChunkSize = Math.max(largestChunkSize, chunkSize);
                }
                if (( board.obj[row][col].rightinfo.equals(Habitat) && !visited[row][col])) {
                    chunkSize = Habitatdfs(board, visited, row, col, Habitat, 3);
                    largestChunkSize = Math.max(largestChunkSize, chunkSize);
                }
                if (( board.obj[row][col].downinfo.equals(Habitat) && !visited[row][col])) {
                    chunkSize = Habitatdfs(board, visited, row, col, Habitat, 4);
                    largestChunkSize = Math.max(largestChunkSize, chunkSize);
                }
                if (( board.obj[row][col].downinfo.equals(Habitat) && !visited[row][col])) {
                    chunkSize = Habitatdfs(board, visited, row, col, Habitat, 5);
                    largestChunkSize = Math.max(largestChunkSize, chunkSize);
                }
                if (( board.obj[row][col].leftinfo.equals(Habitat) && !visited[row][col])) {
                    chunkSize = Habitatdfs(board, visited, row, col, Habitat, 6);
                    largestChunkSize = Math.max(largestChunkSize, chunkSize);
                }
            }
        }
        for(int i=0;i<rows;i++){
            if(i%2==0)
                System.out.print(" ");
            for(int j=0;j<cols;j++){

                if(visited[i][j])
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        return largestChunkSize;
    }
    public static int Habitatdfs(PrintBoard board, boolean[][] visited, int row, int col, String targetChar, int position) {
        if (row < 0 || row >= board.rows || col < 0 || col >= board.cols || visited[row][col] ) {
            return 0;
        }
        if(board.obj[row][col].placed==false)
            return 0;
        if(position==1 && !board.obj[row][col].downinfo.equals(targetChar))
            return 0;
        if(position==2 && !board.obj[row][col].downinfo.equals(targetChar))
            return 0;
        if(position==3 && !board.obj[row][col].leftinfo.equals(targetChar))
            return 0;
        if(position==4 && !board.obj[row][col].upinfo.equals(targetChar))
            return 0;
        if(position==5 && !board.obj[row][col].upinfo.equals(targetChar))
            return 0;
        if(position==6 && !board.obj[row][col].rightinfo.equals(targetChar))
            return 0;

        visited[row][col] = true;
        int size = 1;
        size += Habitatdfs(board, visited, HabitatnextX(board, row, col, 1), HabitatnextY(board, row, col, 1), targetChar,1);
        size += Habitatdfs(board, visited, HabitatnextX(board, row, col, 2), HabitatnextY(board, row, col, 2), targetChar,2);
        size += Habitatdfs(board, visited, HabitatnextX(board, row, col, 3), HabitatnextY(board, row, col, 3), targetChar,3);
        size += Habitatdfs(board, visited, HabitatnextX(board, row, col, 4), HabitatnextY(board, row, col, 4), targetChar,4);
        size += Habitatdfs(board, visited, HabitatnextX(board, row, col, 5), HabitatnextY(board, row, col, 5), targetChar,5);
        size += Habitatdfs(board, visited, HabitatnextX(board, row, col, 6), HabitatnextY(board, row, col, 6), targetChar,6);

        return size;
    }

}
