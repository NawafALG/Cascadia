public class PrintBoard {
    int rows = 8;
    int cols = 8;
    Tile[][] obj;
    PrintBoard(){
        obj = new Tile[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                obj[i][j] = new Tile();
            }
        }
    }
    public void printColnum(){
        System.out.print("      ");
        for(int i =0;i<rows;i++) System.out.print("     "+i+"      ");
        System.out.println();
    }
    public void init(){
        printColnum();
        obj[0][4].placed = true;
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
            output = ""+i+" ";
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

}
