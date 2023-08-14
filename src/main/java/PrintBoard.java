import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PrintBoard {
    int rows = 7;
    int cols = 8;
    Tile[][] obj; // this variable right here prints the whole board

    String playername;
    PrintBoard(){
        obj = new Tile[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                obj[i][j] = new Tile(); // initlisation
            }
        }
    }
    public void printColnum(){
        System.out.print(Colors.HEADER+"      ");
        for(int i =1;i<=cols;i++) {
            if(i == cols/2) System.out.print("      "+playername+"      ");
            System.out.print("            ");

        }
        System.out.println(Colors.reset);

        System.out.print("      ");
        for(int i =1;i<=cols;i++) System.out.print("     "+i+"      ");
        System.out.println();
    }
    public void print(){
        printColnum();
        obj[3][4].placed = true;
        obj[3][3].placed = true;
        obj[2][3].placed = true;
        for(int i =0;i<rows;i++){

            String output = "  ";
            if (i%2==0) output = output.concat("      ");
            for(int j=0;j<cols;j++)
                output = output.concat(obj[i][j].row1());

            System.out.println(output);
            output = "  ";
            if (i%2==0) output = output.concat("      ");
            for(int j=0;j<cols;j++)
                output = output.concat(obj[i][j].row2());

            System.out.println(output);
            int tempRowNum = i+1;
            output = ""+tempRowNum+" ";
            if (i%2==0) output = output.concat("      ");
            for(int j=0;j<cols;j++)
                output = output.concat(obj[i][j].row3());

            System.out.println(output);
            output = "  ";
            if (i%2==0) output = output.concat("      ");
            for(int j=0;j<cols;j++)
                output = output.concat(obj[i][j].row4());

            System.out.println(output);
        }
    }

    public void TestAllTrue(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                obj[i][j].placed = true;
            }
        }
    }


    public void TestAnimalsPlaced(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                obj[i][j].animalSelectedIndex = 0;
                obj[i][j].animaltileplaced = true;
                obj[i][j].updateRowsAnimalTilePlaced();

            }
        }
    }

    public boolean isValidPlacement(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false; // Index is out of bounds
        }

        if (!obj[row][col].placed) {
            boolean adjacentPlaced = false;
            if (row > 0 && obj[row - 1][col].placed) {
                adjacentPlaced = true;
            }
            if (row > 0 && obj[row + 1][col-1].placed && row % 2 != 0) {
                adjacentPlaced = true;
            }
            if (row < rows - 1 && obj[row + 1][col].placed) {
                adjacentPlaced = true;
            }
//            if (row < rows - 1 && obj[row - 1][col+1].placed && row % 2 == 0) {
//                adjacentPlaced = true;
//            }
            if (row > 0 && obj[row - 1][col+1].placed && row % 2 == 0) {
                adjacentPlaced = true;
            }
            if (col > 0 && obj[row][col - 1].placed) {
                adjacentPlaced = true;
            }
            if (col < cols - 1 && obj[row][col + 1].placed) {
                adjacentPlaced = true;
            }
            return adjacentPlaced;
        }
        return false;
    }

    public boolean isValidAnimalTilePlacement(int row, int col, String AnimalType){
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }
        if(!obj[row][col].placed){
            return false;
        }
        if(obj[row][col].animaltileplaced){
            return false;
        }
        return obj[row][col].isValidAnimalTilePlacement(AnimalType);
    }

}
